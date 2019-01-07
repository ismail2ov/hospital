package com.sqli.hopital.domain;

import java.util.List;

public class Diabetes implements Patient {

    @Override
    public HealthStatus getPatientState() {
        return HealthStatus.DIABETES;
    }

    @Override
    public Patient wait40Days(List<Medicine> medicines) {
        if (!medicines.contains(Medicine.INSULIN)) {
            return new Dead();
        }
        return this;
    }
}
