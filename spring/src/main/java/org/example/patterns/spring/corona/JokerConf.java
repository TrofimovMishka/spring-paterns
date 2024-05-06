package org.example.patterns.spring.corona;

import org.example.patterns.spring.corona.one.InjectListBPP;
import org.example.patterns.spring.legacy.LegacyBeanDefenitionRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LegacyBeanDefenitionRegistrar.class})
public class JokerConf {

    @Bean
    public InjectListBPP injectListBPP() {
        return new InjectListBPP();
    }
}
