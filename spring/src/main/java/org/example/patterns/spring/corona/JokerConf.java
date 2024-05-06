package org.example.patterns.spring.corona;

import org.example.patterns.spring.corona.one.InjectListBPP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JokerConf {

    @Bean
    public InjectListBPP injectListBPP() {
        return new InjectListBPP();
    }
}
