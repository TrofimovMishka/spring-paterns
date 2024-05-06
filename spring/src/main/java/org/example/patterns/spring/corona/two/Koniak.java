package org.example.patterns.spring.corona.two;

import org.example.patterns.spring.corona.hospital.Patient;
import org.example.patterns.spring.corona.interf.Treament;

@Treament(type = Leczenie.ALKO)
public class Koniak implements Leczenie{
    @Override
    public void primenit(Patient patient) {
        System.out.println("Use koniak");
    }
}
