package org.example.patterns.spring.chain;

import org.example.patterns.spring.chain.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainHandler2 {
    @Autowired
    private List<Handler> handlers;

    public void handle(DataObject t) {
        handlers.forEach(handler -> handler.handle(t));
    }
}
