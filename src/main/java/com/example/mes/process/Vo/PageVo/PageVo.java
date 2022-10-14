package com.example.mes.process.Vo.PageVo;

public class PageVo {

    //第pageOffset页
    int pageOffset;
    //每页显示的数量
    int pageSize;
    //起始记录下标
    int startOffset;

    public PageVo() {
    }

    public PageVo(int pageOffset, int pageSize) {
        this.pageOffset = pageOffset;
        this.pageSize = pageSize;
        this.startOffset = (pageOffset - 1) * pageSize;
    }

    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public void setStartOffset(int startOffset) {
        this.startOffset = startOffset;
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "pageOffset=" + pageOffset +
                ", pageSize=" + pageSize +
                ", startOffset=" + startOffset +
                '}';
    }
}
