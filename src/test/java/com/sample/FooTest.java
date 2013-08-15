package com.sample;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author markiewb
 */
public class FooTest {

    @Test
    public void testGetList_allFound() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/test/resources/applicationContext_valid.xml");

        Foo bean = (Foo) context.getBean("foo", Foo.class);
        List<Bar> result = bean.getList();
        assertEquals(2, result.size());
    }

    @Test(expected = BeanCreationException.class)
    public void testGetList_oneNotFound() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/test/resources/applicationContext_invalid.xml");

        //exception will be thrown here
        context.getBean("foo", Foo.class);
    }

}
