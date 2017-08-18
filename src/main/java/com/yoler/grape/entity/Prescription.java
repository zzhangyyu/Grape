package com.yoler.grape.entity;

/**
 * 数据库映射-药方
 */
public class Prescription {
    private int id;
    private int patientConditionId;
    private int doctorId;
    private String prescriptionName;
    private String prescriptionDetail;
    private String prescriptionMethod;
    private int prescriptionCount;
    private String prescriptionDuration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientConditionId() {
        return patientConditionId;
    }

    public void setPatientConditionId(int patientConditionId) {
        this.patientConditionId = patientConditionId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getPrescriptionDetail() {
        return prescriptionDetail;
    }

    public void setPrescriptionDetail(String prescriptionDetail) {
        this.prescriptionDetail = prescriptionDetail;
    }

    public String getPrescriptionMethod() {
        return prescriptionMethod;
    }

    public void setPrescriptionMethod(String prescriptionMethod) {
        this.prescriptionMethod = prescriptionMethod;
    }

    public int getPrescriptionCount() {
        return prescriptionCount;
    }

    public void setPrescriptionCount(int prescriptionCount) {
        this.prescriptionCount = prescriptionCount;
    }

    public String getPrescriptionDuration() {
        return prescriptionDuration;
    }

    public void setPrescriptionDuration(String prescriptionDuration) {
        this.prescriptionDuration = prescriptionDuration;
    }
}
