package com.yoler.grape.dao.mapper;

import com.yoler.grape.entity.Patient;

import java.io.Serializable;
import java.util.List;

public interface PatientMapper{
    List<Patient> getPatientList();
}
