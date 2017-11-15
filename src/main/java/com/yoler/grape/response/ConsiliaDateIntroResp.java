package com.yoler.grape.response;

import java.util.List;

public class ConsiliaDateIntroResp {
    private String visitingTime;
    private List<ConsiliaDateIntroPI> patientInfos;

    public String getVisitingTime() {
        return visitingTime;
    }

    public void setVisitingTime(String visitingTime) {
        this.visitingTime = visitingTime;
    }

    public List<ConsiliaDateIntroPI> getPatientInfos() {
        return patientInfos;
    }

    public void setPatientInfos(List<ConsiliaDateIntroPI> patientInfos) {
        this.patientInfos = patientInfos;
    }
}
