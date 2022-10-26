package com.oracle.jp.fn.country;

import io.micronaut.context.annotation.ConfigurationProperties;

/**
 * @author shukawam
 */
@ConfigurationProperties("ords")
public class OrdsConfig {
    private String endpoint;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
