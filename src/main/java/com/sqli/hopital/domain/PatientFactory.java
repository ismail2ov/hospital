package com.sqli.hopital.domain;

public class PatientFactory {

    public static Patient create(String patientStateCode) {
        return new PatientFactory().create(HealthStatus.getHealthStatusBy(patientStateCode));
    }

    private Patient create(HealthStatus patientState) {
        switch (patientState) {
            case FEVER:
                return new Fever();
            case DEAD:
                return new Dead();
            case DIABETES:
                return new Diabetes();
            case TUBERCULOSIS:
                return new Tuberculosis();
            case HEALTHY:
                return new Healthy();
            default:
                throw new RuntimeException("Error creating Patient");
        }
    }
}
