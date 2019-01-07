package com.sqli.hopital.domain;

import java.util.List;

public class Tuberculosis implements Patient {

    @Override
    public HealthStatus getPatientState() {
        return HealthStatus.TUBERCULOSIS;
    }

    @Override
    public Patient wait40Days(List<Medicine> medicine) {
        if (medicine.contains(Medicine.ANTIBIOTIC)) {
            return new Healthy();
        }
        return this;
    }
}
