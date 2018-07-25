package com.yoler.grape.request.mobile;

public class ConsiliaNameDirReqContent {
    private String pageIdx;
    private String recordPerPage;
    private String patientNameLike;

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

    public String getPatientNameLike() {
        return patientNameLike;
    }

    public void setPatientNameLike(String patientNameLike) {
        this.patientNameLike = patientNameLike;
    }
}
