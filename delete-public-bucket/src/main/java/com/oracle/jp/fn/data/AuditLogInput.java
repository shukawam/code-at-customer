package com.oracle.jp.fn.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author shukawam
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditLogInput {
    public Data data;
}
