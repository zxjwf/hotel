package com.myhotel.common.vo;

import java.io.Serializable;
import java.util.List;

public class PageObject<T> implements Serializable {
    private static final long serialVersionUID=6780580291247550747L;

    private Integer pageCurrent=1;
    private Integer pageSize=3;
    private Integer rowCount=0;
    private List<T> records;

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
