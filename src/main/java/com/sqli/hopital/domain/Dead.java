package com.sqli.hopital.domain;

import java.util.List;

public class Dead implements Patient {

    @Override
    public HealthStatus getPatientState() {
        return HealthStatus.DEAD;
    }

    @Override
    public Patient wait40Days(List<Medicine> medicines) {
        return this;
    }
}
