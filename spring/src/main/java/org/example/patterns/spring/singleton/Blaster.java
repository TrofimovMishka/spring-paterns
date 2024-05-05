package org.example.patterns.spring.singleton;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy //if Lazy in this place - not work if any class have injected this bean
@Service
public class Blaster {

    @PostConstruct // work after bean creating
    private void init() {
        System.out.println("you paid 1000500 for the blaster");
    }

    public void fire() {
        System.out.println("Blaster fire");
    }
}
