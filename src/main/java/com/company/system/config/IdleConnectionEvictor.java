//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.config;

import java.util.concurrent.TimeUnit;
import javax.annotation.PreDestroy;
import org.apache.http.conn.HttpClientConnectionManager;

public class IdleConnectionEvictor extends Thread {
    private final HttpClientConnectionManager manager;
    private Integer waitTime;
    private Integer idleConTime;
    private volatile boolean shutdown = true;

    public IdleConnectionEvictor(HttpClientConnectionManager manager, Integer waitTime, Integer idleConTime) {
        this.manager = manager;
        this.waitTime = waitTime;
        this.idleConTime = idleConTime;
        this.start();
    }

    public void run() {
        try {
            if(this.shutdown) {
                synchronized(this) {
                    this.wait((long)this.waitTime.intValue());
                    this.manager.closeIdleConnections((long)this.idleConTime.intValue(), TimeUnit.SECONDS);
                    this.manager.closeExpiredConnections();
                }
            }
        } catch (Exception var4) {
            ;
        }

    }

    @PreDestroy
    public void shutdown() {
        this.shutdown = false;
        synchronized(this) {
            this.notifyAll();
        }
    }
}
