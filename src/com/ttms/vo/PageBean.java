package com.ttms.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public class PageBean<T> implements Serializable{
    private Integer pageSize;
    private Integer currPage;
    private Integer totalCount;
    private Integer totalPage;
    private List<T> list;

    public PageBean(Integer pageSize, Integer currPage, Integer totalCount, List<T> list) {
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalCount = totalCount;
        this.list = list;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalPage() {
        return (int) Math.ceil(totalCount * 1.0 / pageSize);
    }

}
