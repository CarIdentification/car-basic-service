package com.discern.car.common;

import java.io.Serializable;

/**
 * 类描述 :
 *
 * @Author JoeyTsai
 * @Time 12/04/2019
 */
public class Page implements Serializable {
    private Integer offset;
    private Integer limit;
    private Integer count;
    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {

        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
