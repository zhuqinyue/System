//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.entity;

import com.company.system.entity.Target;

public class Data {
    private String attached_info;
    private String type;
    private Target target;
    private String target_description;

    public Data() {
    }

    public void setAttached_info(String attached_info) {
        this.attached_info = attached_info;
    }

    public String getAttached_info() {
        return this.attached_info;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Target getTarget() {
        return this.target;
    }

    public void setTarget_description(String target_description) {
        this.target_description = target_description;
    }

    public String getTarget_description() {
        return this.target_description;
    }
}
