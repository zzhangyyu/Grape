package com.yoler.grape.request;

import java.util.Date;

public class ConsiliaDateIntroReq extends BaseReq {
    private int pageIdx;
    private int recordPerPage;
    private Date queryStartDate;
    private Date queryEndDate;

    public int getPageIdx() {
        return pageIdx;
    }

    public void setPageIdx(int pageIdx) {
        this.pageIdx = pageIdx;
    }

    public int getRecordPerPage() {
        return recordPerPage;
    }

    public void setRecordPerPage(int recordPerPage) {
        this.recordPerPage = recordPerPage;
    }

    public Date getQueryStartDate() {
        return queryStartDate;
    }

    public void setQueryStartDate(Date queryStartDate) {
        this.queryStartDate = queryStartDate;
    }

    public Date getQueryEndDate() {
        return queryEndDate;
    }

    public void setQueryEndDate(Date queryEndDate) {
        this.queryEndDate = queryEndDate;
    }
}
