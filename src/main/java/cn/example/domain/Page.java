package cn.example.domain;

import java.io.Serializable;

/**
 * 分页实体
 */
public class Page implements Serializable {
    private Integer start;
    private Integer rows;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
