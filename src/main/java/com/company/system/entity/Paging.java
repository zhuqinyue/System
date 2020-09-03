//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.entity;

public class Paging {
    private boolean is_end;
    private int totals;
    private String next;
    private boolean is_start;
    private String previous;

    public Paging() {
    }

    public void setIs_end(boolean is_end) {
        this.is_end = is_end;
    }

    public boolean getIs_end() {
        return this.is_end;
    }

    public void setTotals(int totals) {
        this.totals = totals;
    }

    public int getTotals() {
        return this.totals;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getNext() {
        return this.next;
    }

    public void setIs_start(boolean is_start) {
        this.is_start = is_start;
    }

    public boolean getIs_start() {
        return this.is_start;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getPrevious() {
        return this.previous;
    }
}
