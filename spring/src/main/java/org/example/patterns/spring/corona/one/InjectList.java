package org.example.patterns.spring.corona.one;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectList {
    Class[] values();
}
