package org.example.patterns.spring.corona.one;

import org.example.patterns.spring.corona.hospital.Patient;

public interface Celitel {
    void healing(Patient patient);

    String myType();

    String TRAD = "traditional";
    String NAROD = "folk";
}
