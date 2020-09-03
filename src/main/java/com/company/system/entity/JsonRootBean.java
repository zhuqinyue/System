//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.entity;

import com.company.system.entity.Data;
import com.company.system.entity.Paging;
import java.util.List;

public class JsonRootBean {
    private Paging paging;
    private String version;
    private List<Data> data;

    public JsonRootBean() {
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public Paging getPaging() {
        return this.paging;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return this.data;
    }
}
