package org.example.patterns.spring.strategy_and_command;

import org.example.patterns.spring.corona.hospital.Patient;

public interface Hospital {
    void processPatient(Patient patient);
}
