package org.example.patterns.spring.chain.handlers;

import org.example.patterns.spring.chain.DataObject;
import org.springframework.stereotype.Component;

@Component
public class AddHandler implements Handler {
    @Override
    public void handle(DataObject t) {
        System.out.println("Handling by AddHAndler");
    }
}
