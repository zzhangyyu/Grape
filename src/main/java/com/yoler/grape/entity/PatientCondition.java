package com.yoler.grape.entity;

import java.util.Date;

/**
 * 数据库映射-病历
 */
public class PatientCondition {
    private int id;
    private int patientInfoId;
    private Date visitingDate;
    private String leftPulseCun;
    private String leftPulseGuan;
    private String leftPulseChi;
    private String rightPulseCun;
    private String rightPulseGuan;
    private String rightPulseChi;
    private String tongue;
    private String addCondition;
    private String analysis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientInfoId() {
        return patientInfoId;
    }

    public void setPatientInfoId(int patientInfoId) {
        this.patientInfoId = patientInfoId;
    }

    public Date getVisitingDate() {
        return visitingDate;
    }

    public void setVisitingDate(Date visitingDate) {
        this.visitingDate = visitingDate;
    }

    public String getLeftPulseCun() {
        return leftPulseCun;
    }

    public void setLeftPulseCun(String leftPulseCun) {
        this.leftPulseCun = leftPulseCun;
    }

    public String getLeftPulseGuan() {
        return leftPulseGuan;
    }

    public void setLeftPulseGuan(String leftPulseGuan) {
        this.leftPulseGuan = leftPulseGuan;
    }

    public String getLeftPulseChi() {
        return leftPulseChi;
    }

    public void setLeftPulseChi(String leftPulseChi) {
        this.leftPulseChi = leftPulseChi;
    }

    public String getRightPulseCun() {
        return rightPulseCun;
    }

    public void setRightPulseCun(String rightPulseCun) {
        this.rightPulseCun = rightPulseCun;
    }

    public String getRightPulseGuan() {
        return rightPulseGuan;
    }

    public void setRightPulseGuan(String rightPulseGuan) {
        this.rightPulseGuan = rightPulseGuan;
    }

    public String getRightPulseChi() {
        return rightPulseChi;
    }

    public void setRightPulseChi(String rightPulseChi) {
        this.rightPulseChi = rightPulseChi;
    }

    public String getTongue() {
        return tongue;
    }

    public void setTongue(String tongue) {
        this.tongue = tongue;
    }

    public String getAddCondition() {
        return addCondition;
    }

    public void setAddCondition(String addCondition) {
        this.addCondition = addCondition;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
}

