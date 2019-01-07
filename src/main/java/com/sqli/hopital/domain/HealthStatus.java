package com.sqli.hopital.domain;

import java.util.stream.Stream;

public enum HealthStatus {
    FEVER("F"),
    HEALTHY("H"),
    DIABETES("D"),
    TUBERCULOSIS("T"),
    DEAD("X");

    private final String statusCode;

    HealthStatus(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public static HealthStatus getHealthStatusBy(String statusCode) {
        return Stream.of(HealthStatus.values())
                .filter(x -> x.getStatusCode().equals(statusCode))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unknown medicine"));
    }
}
