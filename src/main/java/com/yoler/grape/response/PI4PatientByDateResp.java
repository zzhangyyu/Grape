package com.yoler.grape.response;

/**
 * getPatientByDate接口的病人信息(Patient_Info)
 */
public class PI4PatientByDateResp {

    private String patientId;
    private String patientName;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
