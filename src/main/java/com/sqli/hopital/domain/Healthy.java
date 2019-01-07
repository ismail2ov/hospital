package com.sqli.hopital.domain;

import java.util.List;

public class Healthy implements Patient {

    @Override
    public HealthStatus getPatientState() {
        return HealthStatus.HEALTHY;
    }

    @Override
    public Patient wait40Days(List<Medicine> medicines) {
        if (medicines.contains(Medicine.ANTIBIOTIC) && medicines.contains(Medicine.INSULIN)) {
            return new Fever();
        }
        return this;
    }
}
