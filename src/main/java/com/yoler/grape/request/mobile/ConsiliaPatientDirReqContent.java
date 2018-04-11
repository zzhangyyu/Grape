package com.yoler.grape.request.mobile;

public class ConsiliaPatientDirReqContent {
    private String pageIdx;
    private String recordPerPage;

    public String getPageIdx() {
        return pageIdx;
    }

    public void setPageIdx(String pageIdx) {
        this.pageIdx = pageIdx;
    }

    public String getRecordPerPage() {
        return recordPerPage;
    }

    public void setRecordPerPage(String recordPerPage) {
        this.recordPerPage = recordPerPage;
    }

}
