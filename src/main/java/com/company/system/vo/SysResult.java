//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class SysResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private Integer status;
    private String msg;
    private Object data;
    private String location;

    public static SysResult build(Integer status, String msg, Object data) {
        return new SysResult(status, msg, data);
    }

    public static SysResult oK(Object data) {
        return new SysResult(data);
    }

    public static SysResult oK() {
        return new SysResult((Object)null);
    }

    public SysResult() {
    }

    public static SysResult build(Integer status, String msg) {
        return new SysResult(status, msg, (Object)null);
    }

    public SysResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public SysResult(Object data) {
        this.status = Integer.valueOf(0);
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOk() {
        return Boolean.valueOf(this.status.intValue() == 0);
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public static SysResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if(clazz == null) {
                return (SysResult)MAPPER.readValue(jsonData, SysResult.class);
            } else {
                JsonNode e = MAPPER.readTree(jsonData);
                JsonNode data = e.get("data");
                Object obj = null;
                if(clazz != null) {
                    if(data.isObject()) {
                        obj = MAPPER.readValue(data.traverse(), clazz);
                    } else if(data.isTextual()) {
                        obj = MAPPER.readValue(data.asText(), clazz);
                    }
                }

                return build(Integer.valueOf(e.get("status").intValue()), e.get("msg").asText(), obj);
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static SysResult format(String json) {
        try {
            return (SysResult)MAPPER.readValue(json, SysResult.class);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static SysResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode e = MAPPER.readTree(jsonData);
            JsonNode data = e.get("data");
            Object obj = null;
            if(data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(), MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }

            return build(Integer.valueOf(e.get("status").intValue()), e.get("msg").asText(), obj);
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }
}
