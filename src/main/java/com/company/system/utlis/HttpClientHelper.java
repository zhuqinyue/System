//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.utlis;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HttpClientHelper {
    private Logger LOGGER = LoggerFactory.getLogger(HttpClientHelper.class);
    @Autowired
    private CloseableHttpClient httpClient;
    @Autowired
    private RequestConfig requestConfig;

    public HttpClientHelper() {
    }

    public String get(String url, HashMap<String, Object> paramMap, HashMap<String, Object> header) {
        String result = null;
        if("".equals(url)) {
            return result;
        } else {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = null;

            try {
                httpGet.setConfig(this.requestConfig);
                if(paramMap != null && paramMap.size() > 0) {
                    ArrayList e = new ArrayList();
                    Iterator entry = paramMap.entrySet().iterator();

                    while(entry.hasNext()) {
                        Entry realParams = (Entry)entry.next();
                        e.add(new BasicNameValuePair((String)realParams.getKey(), URLEncoder.encode(realParams.getValue().toString(), "UTF-8")));
                    }

                    String entry1 = EntityUtils.toString(new UrlEncodedFormEntity(e));
                    String realParams1 = URLDecoder.decode(entry1, "UTF-8");
                    httpGet.setURI(new URI(httpGet.getURI().toString().indexOf("?") > 0?httpGet.getURI().toString() + "&" + realParams1:httpGet.getURI().toString() + "?" + realParams1));
                }

                if(header != null && header.size() > 0) {
                    Iterator e1 = header.entrySet().iterator();

                    while(e1.hasNext()) {
                        Entry entry2 = (Entry)e1.next();
                        httpGet.addHeader((String)entry2.getKey(), entry2.getValue().toString());
                    }
                }

                response = this.httpClient.execute(httpGet);
                result = this.parseResponse(response);
            } catch (Exception var18) {
                this.LOGGER.error("url : " + url + ", msg : " + var18.getMessage());
                httpGet.abort();
            } finally {
                try {
                    if(response != null) {
                        response.close();
                    }
                } catch (IOException var17) {
                    var17.printStackTrace();
                }

            }

            return result;
        }
    }

    public String post(String url, HashMap<String, Object> paramMap, HashMap<String, Object> header) {
        String result = null;
        if("".equals(url)) {
            return result;
        } else {
            HttpPost httpPost = new HttpPost(url);
            CloseableHttpResponse response = null;

            try {
                httpPost.setConfig(this.requestConfig);
                if(paramMap != null && paramMap.size() > 0) {
                    ArrayList e = new ArrayList();
                    Iterator entry = paramMap.entrySet().iterator();

                    while(entry.hasNext()) {
                        Entry entry1 = (Entry)entry.next();
                        e.add(new BasicNameValuePair((String)entry1.getKey(), entry1.getValue().toString()));
                    }

                    UrlEncodedFormEntity entry2 = new UrlEncodedFormEntity(e);
                    httpPost.setEntity(entry2);
                }

                if(header != null && header.size() > 0) {
                    Iterator e1 = header.entrySet().iterator();

                    while(e1.hasNext()) {
                        Entry entry3 = (Entry)e1.next();
                        httpPost.addHeader((String)entry3.getKey(), entry3.getValue().toString());
                    }
                }

                response = this.httpClient.execute(httpPost);
                result = this.reponseHandle(response);
            } catch (Exception var18) {
                this.LOGGER.error("url : " + url + ", msg : " + var18.getMessage());
                httpPost.abort();
            } finally {
                try {
                    if(response != null) {
                        response.close();
                    }
                } catch (IOException var17) {
                    var17.printStackTrace();
                }

            }

            return result;
        }
    }

    public String postJSON(String url, String json_str, HashMap<String, Object> header) {
        String result = null;
        if("".equals(url)) {
            return result;
        } else {
            HttpPost httpPost = new HttpPost(url);
            CloseableHttpResponse response = null;

            try {
                httpPost.setConfig(this.requestConfig);
                if(json_str != null && !"".equals(json_str)) {
                    StringEntity e = new StringEntity(json_str, ContentType.APPLICATION_JSON);
                    e.setContentEncoding("UTF-8");
                    e.setContentType("application/json");
                    httpPost.setEntity(e);
                }

                if(header != null && header.size() > 0) {
                    Iterator e1 = header.entrySet().iterator();

                    while(e1.hasNext()) {
                        Entry entry = (Entry)e1.next();
                        httpPost.addHeader((String)entry.getKey(), entry.getValue().toString());
                    }
                }

                response = this.httpClient.execute(httpPost);
                result = this.reponseHandle(response);
            } catch (Exception var17) {
                this.LOGGER.error("url : " + url + ", msg : " + var17.getMessage() + ", param : " + json_str);
                httpPost.abort();
            } finally {
                try {
                    if(response != null) {
                        response.close();
                    }
                } catch (IOException var16) {
                    var16.printStackTrace();
                }

            }

            return result;
        }
    }

    public String uploadFile(String url, String filePath, String fileParam, Map<String, Object> params) {
        File file = new File(filePath);
        if(file.exists() && file.isFile()) {
            String result = null;
            if("".equals(url)) {
                return result;
            } else {
                HttpPost httpPost = new HttpPost(url);
                CloseableHttpResponse response = null;

                try {
                    httpPost.setConfig(this.requestConfig);
                    MultipartEntityBuilder e = MultipartEntityBuilder.create();
                    e.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                    e.addBinaryBody(fileParam, file, ContentType.DEFAULT_BINARY, file.getName());
                    if(params != null && params.size() > 0) {
                        Iterator requestEntity = params.entrySet().iterator();

                        while(requestEntity.hasNext()) {
                            Entry entry = (Entry)requestEntity.next();
                            e.addTextBody((String)entry.getKey(), entry.getValue().toString(), ContentType.create("text/plain", Consts.UTF_8));
                        }
                    }

                    HttpEntity requestEntity1 = e.build();
                    httpPost.setEntity(requestEntity1);
                    response = this.httpClient.execute(httpPost);
                    result = this.reponseHandle(response);
                } catch (Exception var20) {
                    httpPost.abort();
                } finally {
                    try {
                        if(response != null) {
                            response.close();
                        }
                    } catch (IOException var19) {
                        var19.printStackTrace();
                    }

                }

                return result;
            }
        } else {
            throw new RuntimeException("file : file is null");
        }
    }

    private String parseResponse(CloseableHttpResponse response) {
        String result = "";
        HttpEntity httpEntity = null;
        InputStream inputStream = null;

        try {
            int e = response.getStatusLine().getStatusCode();
            if(e < 200 || e >= 300) {
                throw new RuntimeException("statusCode : " + e);
            }

            httpEntity = response.getEntity();
            if(httpEntity != null) {
                inputStream = httpEntity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                StringBuffer sb = new StringBuffer();
                String line = "";

                while((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                reader.close();
                result = sb.toString();
            }
        } catch (Exception var21) {
            this.LOGGER.error("HttpClientHelper parseResponse error", var21);
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException var20) {
                    var20.printStackTrace();
                }
            }

            try {
                EntityUtils.consume(httpEntity);
            } catch (IOException var19) {
                var19.printStackTrace();
            }

        }

        return result;
    }

    private String reponseHandle(CloseableHttpResponse response) {
        String result = "";
        HttpEntity httpEntity = null;

        try {
            int e = response.getStatusLine().getStatusCode();
            if(e < 200 || e >= 300) {
                throw new RuntimeException("statusCode : " + e);
            }

            httpEntity = response.getEntity();
            if(httpEntity != null) {
                result = EntityUtils.toString(httpEntity);
            }
        } catch (Exception var13) {
            this.LOGGER.error("HttpClientHelper reponseHandle error", var13);
        } finally {
            try {
                EntityUtils.consume(httpEntity);
            } catch (IOException var12) {
                var12.printStackTrace();
            }

        }

        return result;
    }
}
