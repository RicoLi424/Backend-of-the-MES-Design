package com.example.mes.WorkshopStorage.vo;

import java.util.List;

public class PageVo<T> {
    /**
     * 总条数
     */
    private long total;

    /**
     * 总页数
     */
    private long size;

    /**
     * 当前分页总页数
     */
    private long pages;

    /**
     * 当前页
     */
    private long current;

    /**
     * 分页对象记录列表
     */
    private List<T> records;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
