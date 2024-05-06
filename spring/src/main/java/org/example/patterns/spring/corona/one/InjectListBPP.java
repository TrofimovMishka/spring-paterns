package org.example.patterns.spring.corona.one;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.reflections.ReflectionUtils;


import java.beans.Introspector;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class InjectListBPP implements BeanPostProcessor {

    @Autowired
    private ApplicationContext context;

    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Set<Field> fields = ReflectionUtils.getAllFields(bean.getClass(), field -> field.isAnnotationPresent(InjectList.class));

        for (Field field : fields) {
            InjectList annotation = field.getAnnotation(InjectList.class);
            List<Object> list = Arrays.stream(annotation.values())
                    .map(aClass -> Introspector.decapitalize(aClass.getSimpleName())) // transform class name to lowercase first letter
                    .map(name -> context.getBean(name))
                    .toList();
            field.setAccessible(true);
            field.set(bean, list);
        }

        return bean;
    }
}
