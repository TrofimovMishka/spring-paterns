package org.example.patterns.spring.resource;

import lombok.RequiredArgsConstructor;
import org.example.patterns.spring.corona.hospital.Patient;
import org.example.patterns.spring.strategy_and_command.Hospital;
import org.example.patterns.spring.strategy_and_command.PatientStatus;
import org.springframework.web.bind.annotation.*;
import org.example.patterns.spring.strategy_and_command.PSRService;
import static java.time.LocalTime.now;

@RestController
@RequiredArgsConstructor
@RequestMapping("/corona/")
public class CoronaController {

    private final Hospital hospital;
    private final PSRService diagnosticService;

    @PostMapping("treat")
    public Patient threat(@RequestBody Patient patient) {
        hospital.processPatient(patient);
        return patient;
    }

    @GetMapping("diagnose")
    public PatientStatus getPatientStatus(@PathVariable String name) {
        return new PatientStatus(diagnosticService.isPositive(), now());
    }
}
