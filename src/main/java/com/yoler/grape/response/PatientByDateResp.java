package com.yoler.grape.response;

import java.util.List;

public class PatientByDateResp {
    private String visitingTime;
    private List<PI4PatientByDateResp> piList;

    public String getVisitingTime() {
        return visitingTime;
    }

    public void setVisitingTime(String visitingTime) {
        this.visitingTime = visitingTime;
    }

    public List<PI4PatientByDateResp> getPiList() {
        return piList;
    }

    public void setPiList(List<PI4PatientByDateResp> piList) {
        this.piList = piList;
    }

}
