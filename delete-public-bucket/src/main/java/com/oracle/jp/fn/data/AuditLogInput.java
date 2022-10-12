package com.oracle.jp.fn.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author shukawam
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditLogInput {
    public Data data;
//    public String dataschema;
//    public String id;
//    public Object oracle;
//    public String source;
//    public String specversion;
//    public String time;
//    public String type;
}
