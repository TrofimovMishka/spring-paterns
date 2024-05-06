package org.example.patterns.spring.corona.two;

import org.example.patterns.spring.corona.hospital.Patient;
import org.springframework.stereotype.Component;

@Component
public class Aspirin implements Leczenie{
    @Override
    public void primenit(Patient patient) {
        System.out.println("USe 2 pills aspirin in hears");
    }
}
