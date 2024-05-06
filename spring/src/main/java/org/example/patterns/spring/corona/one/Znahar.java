package org.example.patterns.spring.corona.one;

import org.example.patterns.spring.corona.two.Aspirin;
import org.example.patterns.spring.corona.two.Banka;
import org.example.patterns.spring.corona.two.Koniak;
import org.example.patterns.spring.corona.two.Leczenie;
import org.example.patterns.spring.corona.hospital.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Znahar implements Celitel{

//    @Autowired
//    private Leczenie vodka;

    // How add custom list - only needed beans - not all beans who implement Leczenie. Create Custom annotation with BeanPostProcessor handler
    @InjectList(values = {Banka.class, Aspirin.class})
    private List<Leczenie> leczenies;

    // Inject all beans who implememnt Leczenie
//    @Autowired
//    private List<Leczenie> leczenies;

    @Override
    public void healing(Patient patient) {
        System.out.println("opridel leczenie");
        leczenies.forEach(leczenie -> leczenie.primenit(patient));
    }
}
