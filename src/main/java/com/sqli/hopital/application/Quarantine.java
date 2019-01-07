package com.sqli.hopital.application;

import com.sqli.hopital.domain.HealthStatus;
import com.sqli.hopital.domain.Medicine;
import com.sqli.hopital.domain.Patient;
import com.sqli.hopital.domain.PatientFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quarantine {
    private List<Patient> patients;
    private List<Medicine> medicine = new ArrayList<>();

    public Quarantine(String subjects) {
        this.patients = Stream.of(subjects.split(","))
                .map(PatientFactory::create)
                .collect(Collectors.toList());
    }

    public void aspirin() {
        this.medicine.add(Medicine.ASPIRIN);
    }

    public void antibiotic() {
        this.medicine.add(Medicine.ANTIBIOTIC);
    }

    public void insulin() {
        this.medicine.add(Medicine.INSULIN);
    }

    public void paracetamol() {
        this.medicine.add(Medicine.PARACETAMOL);
    }

    public void wait40Days() {
        patients = patients.stream().map(e -> e.wait40Days(medicine)).collect(Collectors.toList());
    }

    public String report() {
        return getFormattedReport(patientStateAfterMedicine());
    }

    private Map<String, Long> patientStateAfterMedicine() {
        return patients.stream()
                .map(patients -> patients.getPatientState().getStatusCode())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private String getFormattedReport(Map<String, Long> map) {
        String result = "";

        for (HealthStatus patientState : HealthStatus.values()) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += patientState.getStatusCode() + ":" + (map.containsKey(patientState.getStatusCode()) ? map.get(patientState.getStatusCode()) : "0");
        }
        return result;
    }
}
