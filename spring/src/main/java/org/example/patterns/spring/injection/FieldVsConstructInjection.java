package org.example.patterns.spring.injection;

public class FieldVsConstructInjection {
    //Constructor injection:
    // + for test propose. If create class instance using 'new' keyword
    // - if using Lombok, as a result in old version of Intellij IDE we can't see error that this bean no unique or no bean for injecting

    // methods injecting:
    // + more custom control during injecting

    //using @Primary annotation for mark bean as main bean.
    // @Qualifier -
}
