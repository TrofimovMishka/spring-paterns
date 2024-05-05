package org.example.patterns.spring.singleton;

public class Singleton {
    // Why singleton is anti-patterns:
    // 1. Makes coupling
    // 2. Provoke to write ugly code
    // 3. Can't test without PowerMock (can mock static fields)
    // 4. Against Single Responsibility

    // How declare singleton correct in Spring:
    // 1. Annotation (@Component) and Configuration (@Bean):
        // @ComponentScan => scan packages and try to find classes with @Component => @Service, @Repository, @RestController, @Controller, @Configuration
        // Difference between annotations - @Repository - bean will be proxy and all exceptions wrap to Excaptions
        // @RestController vs @Controller - DispatcherServlet  build map routing, @RestController have in build annotation @ResponseBody
        // @Configuration is this a bean

    // Lazy singleton:
    /*
    @Lazy
    @Component
    class YourSingleton { ...}
     */

}
