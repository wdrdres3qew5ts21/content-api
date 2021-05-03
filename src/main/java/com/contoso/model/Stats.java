package com.contoso.model;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Stats {

    @Inject
    private Counter counters;

    private String hostname;

    private long uptime;

    public Stats() {
        String hostname = null;
        RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.hostname = hostname;
        this.uptime = rb.getUptime();
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Counter getCounters() {
        return counters;
    }

    public void setCounters(Counter counters) {
        this.counters = counters;
    }

    public long getUptime() {
        return uptime;
    }

    public void setUptime(long uptime) {
        this.uptime = uptime;
    }

    @Override
    public String toString() {
        return "Stats [counters=" + counters + ", hostname=" + hostname + ", uptime=" + uptime + "]";
    }

}
