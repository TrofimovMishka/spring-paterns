package org.example.patterns.spring.corona.interf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Component
@Qualifier
@Autowired
public @interface Treament {
    //String value(); // @Component already have value and default it is class name from lower letter, and we override this.
    // if few bean will be injected using this annotation - ConflictingBeanDefinitionException will occurs.
    // We can change this to :
    String type() default "";
    // And value from @Component will work
}
