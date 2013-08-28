package com.sample.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author markiewb
 */
public class StringToBeanConverter extends CustomCollectionEditor implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public StringToBeanConverter() {
        this(List.class);
    }
    
    public StringToBeanConverter(Class collectionType) {
        super(collectionType);
    }

    @Override
    public void setAsText(String text) {
        String[] names = text.split(",");
        List result = new ArrayList();
        for (String name : names) {
            Object bean = null;
            try {
                bean = applicationContext.getBean(name);
            } catch (NoSuchBeanDefinitionException ex) {
                throw new IllegalArgumentException(String.format("Cannot find bean '%s' referenced in '%s'", name, Arrays.asList(names)));
            }
            result.add(bean);
        }
        setValue(result);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
