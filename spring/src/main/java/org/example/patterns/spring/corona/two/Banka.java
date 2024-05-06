package org.example.patterns.spring.corona.two;

import org.example.patterns.spring.corona.hospital.Patient;
import org.springframework.stereotype.Component;

@Component
public class Banka implements Leczenie{
    @Override
    public void primenit(Patient patient) {
        System.out.println("Use Banki 3 times per day");
    }
}
