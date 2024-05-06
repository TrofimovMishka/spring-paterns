package org.example.patterns.spring.legacy;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.beans.Introspector;
import java.util.Set;

public class LegacyBeanDefenitionRegistrar implements ImportBeanDefinitionRegistrar {
    // The goal of this class it is find classes from other JAR with annotations that Spring not understand and register
    // this classes like a Bean in context to allow Spring managed this Bean from other framework

//    @Value("${application.package-to-scan}")
   private String prefix = "com.naya.corona.legacy";


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        Reflections scanner = new Reflections(prefix);
        // Singlenton.class this is annotation from other JAR that Spring not understand
        Set<Class<?>> classes = scanner.getTypesAnnotatedWith(Singlenton.class);
        for (Class<?> clazz : classes) {
            //Create manually bean definition:
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(clazz);
            beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
            //Using this annotation like a example if we want autowired only beans from other frameworks
            // We must register this Registrar in Config using @Import annotation :
            /*
            @Import({LegacyBeanDefenitionRegistrar.class})
            public class JokerConf {
             */
            beanDefinition.addQualifier(new AutowireCandidateQualifier(Legacy.class));

            //Register new bean using registry
            registry.registerBeanDefinition(Introspector.decapitalize(clazz.getSimpleName()), beanDefinition);
            // As a result all classes will be register like a beans in context
        }
    }
}
