package com.yoler.grape.entity;

import java.util.Date;

/**
 * 数据库表映射-谷大夫挂号表
 */
public class RegisterGuJingbo {
    private int id;
    private Date intentionDate;
    private String intentionWeek;
    private String patientName;
    private String patientSex;
    private String patientAge;
    private String patientPhone;
    private String patientIntro;
    private String firstFlag;
    private Date createDate;
    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIntentionDate() {
        return intentionDate;
    }

    public void setIntentionDate(Date intentionDate) {
        this.intentionDate = intentionDate;
    }

    public String getIntentionWeek() {
        return intentionWeek;
    }

    public void setIntentionWeek(String intentionWeek) {
        this.intentionWeek = intentionWeek;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientIntro() {
        return patientIntro;
    }

    public void setPatientIntro(String patientIntro) {
        this.patientIntro = patientIntro;
    }

    public String getFirstFlag() {
        return firstFlag;
    }

    public void setFirstFlag(String firstFlag) {
        this.firstFlag = firstFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
