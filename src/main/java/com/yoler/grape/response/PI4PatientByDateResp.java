package com.yoler.grape.response;

/**
 * getPatientByDate接口的病人信息(Patient_Info)
 */
public class PI4PatientByDateResp {

    private String patientInfoId;
    private String patientConditionId;
    private String patientName;

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
