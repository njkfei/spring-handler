package com.jpnie.demo.bean;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by njp on 18/5/3.
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
    }
}
