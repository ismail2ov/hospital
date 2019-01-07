package com.sqli.hopital.domain;

import java.util.List;

public interface Patient {

    HealthStatus getPatientState();

    Patient wait40Days(List<Medicine> medicines);
}
