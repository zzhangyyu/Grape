package com.yoler.grape.response.mobile;

import java.util.List;

public class ConsiliaDateIntroResp {
    private String visitingDate;
    private List<ConsiliaDateIntroPI> patientInfos;

    public String getVisitingDate() {
        return visitingDate;
    }

    public void setVisitingDate(String visitingDate) {
        this.visitingDate = visitingDate;
    }

    public List<ConsiliaDateIntroPI> getPatientInfos() {
        return patientInfos;
    }

    public void setPatientInfos(List<ConsiliaDateIntroPI> patientInfos) {
        this.patientInfos = patientInfos;
    }
}
