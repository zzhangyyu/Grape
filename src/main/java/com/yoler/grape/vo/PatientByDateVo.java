package com.yoler.grape.vo;

public class PatientByDateVo {
    private String visitingDate;
    private String patientInfoId;
    private String patientConditionId;
    private String patientName;

    public String getVisitingDate() {
        return visitingDate;
    }

    public void setVisitingDate(String visitingDate) {
        this.visitingDate = visitingDate;
    }

    public String getPatientInfoId() {
        return patientInfoId;
    }

    public void setPatientInfoId(String patientInfoId) {
        this.patientInfoId = patientInfoId;
    }

    public String getPatientConditionId() {
        return patientConditionId;
    }

    public void setPatientConditionId(String patientConditionId) {
        this.patientConditionId = patientConditionId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
