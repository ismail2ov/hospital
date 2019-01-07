package com.sqli.hopital.domain;

import java.util.List;

public class Fever implements Patient {

    @Override
    public HealthStatus getPatientState() {
        return HealthStatus.FEVER;
    }

    @Override
    public Patient wait40Days(List<Medicine> medicines) {
        if (medicines.contains(Medicine.ASPIRIN) || medicines.contains(Medicine.PARACETAMOL)) {
            return new Healthy();
        }
        return this;
    }
}
