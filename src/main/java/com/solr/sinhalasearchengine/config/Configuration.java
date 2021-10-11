package com.solr.sinhalasearchengine.config;

public class Configuration
{
    private String ip;
    private int port;
    private String core;

    private static Configuration configuration;

    private Configuration() {
    }

    public static Configuration getInstance() {
        if (configuration == null) {
            synchronized (Configuration.class) {
                if (configuration == null) {
                    configuration = new Configuration();
                }
            }
        }
        return configuration;
    }

    public void initializeConfig(String ip, int port, String core) {
        this.ip = ip;
        this.port = port;
        this.core = core;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }
}
