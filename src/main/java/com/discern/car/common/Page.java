package com.discern.car.common;

import java.io.Serializable;

/**
 * 类描述 :
 *
 * @Author JoeyTsai
 * @Time 12/04/2019
 */
public class Page implements Serializable {
    private Integer limit;
    private Integer page;
    private Integer count;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCount() {

        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
