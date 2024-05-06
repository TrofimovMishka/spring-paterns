package org.example.patterns.spring.strategy_and_command;

import org.example.patterns.spring.corona.hospital.Patient;
import org.example.patterns.spring.corona.one.Celitel;
import org.example.patterns.spring.corona.one.Znahar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class HospitalImpl implements Hospital {

//    @Autowired
//    private Znahar znahar;
//    @Autowired
//    private Celitel celitel;


//    @Autowired //1.
    Map<String, Celitel> map;
    // String is ID of Bean and this ID must be equals with method of leczenia from Patient

//2.
    public HospitalImpl(List<Celitel> celitels) {
        map = celitels.stream().collect(Collectors.toMap(Celitel::myType, Function.identity()));
    }

    //3.OR in @Configuration create bean and spring will use this and that you can simply inject this Map in you service
//    @Bean
//    public  Map<String, Celitel> map2 (List<Celitel> celitels) {
//        return celitels.stream().collect(Collectors.toMap(Celitel::myType, Function.identity()));
//    }

    @Override
    public void processPatient(Patient patient) {
        System.out.println("Processing patient");
        // Problem in this place that to add new method need open this class to changes, and this is bad practice
        // after few years we can have a lot, a lot of switch case statements
//        switch (patient.getMethod()) {
//            case Celitel.NAROD -> System.out.println("Znachr iscelaet");
//            case Celitel.TRAD -> System.out.println("Vrach leczit");
//            default -> System.out.println("Znachr ist nicht gefunden");
//        }
        //Solution is Startegy pattern: You have a hospital with Map of strategy of leczenie
//1.
        //Add to @Component("method of leczenia") and Spring create a map with all Bean ID VS beans
        map.getOrDefault(patient.getMethod(), new Celitel() {
            @Override
            public void healing(Patient patient) {
                System.out.println("Zabej, samo projdet");
            }
//2.
            @Override
            public String myType() {
                return "default";
            }
        });

    }
}
