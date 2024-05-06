package org.example.patterns.spring.corona.two;

import org.example.patterns.spring.corona.hospital.Patient;
import org.example.patterns.spring.corona.interf.Treament;
import org.springframework.stereotype.Component;

@Treament(type = Leczenie.ALKO)
public class Vodka implements Leczenie{
    @Override
    public void primenit(Patient patient) {
        System.out.println("Vodka primenit 100g per 3 days");
    }
}
