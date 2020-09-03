//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.config;

import com.company.system.config.IdleConnectionEvictor;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HttpContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfig {
    private int maxTotal = 800;
    private int defaultMaxPerRoute = 80;
    private int validateAfterInactivity = 1000;
    private int connectionRequestTimeout = 5000;
    private int connectTimeout = 10000;
    private int socketTimeout = 20000;
    private int waitTime = 30000;
    private int idleConTime = 3;
    private int retryCount = 3;

    public HttpClientConfig() {
    }

    @Bean
    public PoolingHttpClientConnectionManager createPoolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager poolmanager = new PoolingHttpClientConnectionManager();
        poolmanager.setMaxTotal(this.maxTotal);
        poolmanager.setDefaultMaxPerRoute(this.defaultMaxPerRoute);
        poolmanager.setValidateAfterInactivity(this.validateAfterInactivity);
        return poolmanager;
    }

    @Bean
    public CloseableHttpClient createHttpClient(PoolingHttpClientConnectionManager poolManager) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create().setConnectionManager(poolManager);
        httpClientBuilder.setKeepAliveStrategy(new ConnectionKeepAliveStrategy() {
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                BasicHeaderElementIterator iterator = new BasicHeaderElementIterator(response.headerIterator("Keep-Alive"));

                String param;
                String value;
                do {
                    if(!iterator.hasNext()) {
                        return 30000L;
                    }

                    HeaderElement headerElement = iterator.nextElement();
                    param = headerElement.getName();
                    value = headerElement.getValue();
                } while(null == value || !param.equalsIgnoreCase("timeout"));

                return Long.parseLong(value) * 1000L;
            }
        });
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(this.retryCount, false));
        return httpClientBuilder.build();
    }

    @Bean
    public RequestConfig createRequestConfig() {
        return RequestConfig.custom().setConnectionRequestTimeout(this.connectionRequestTimeout).setConnectTimeout(this.connectTimeout).setSocketTimeout(this.socketTimeout).build();
    }

    @Bean
    public IdleConnectionEvictor createIdleConnectionEvictor(PoolingHttpClientConnectionManager poolManager) {
        IdleConnectionEvictor idleConnectionEvictor = new IdleConnectionEvictor(poolManager, Integer.valueOf(this.waitTime), Integer.valueOf(this.idleConTime));
        return idleConnectionEvictor;
    }
}
