package com.ragini.services;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class Main2 {                    // ******  BeanFactory   *****

    public static void main(String[] args){  // Lazy initialization

        DefaultListableBeanFactory container =
                new DefaultListableBeanFactory();
//
//        XmlBeanDefinitionReader read = new XmlBeanDefinitionReader(container);
//        read.loadBeanDefinitions("applicationContext.xml");
//
//        TShaped tShaped = container.getBean(TShaped.class);
//        boolean status = tShaped.buyCourse(499.9);
//
//        if(status){
//            System.out.println("Successful !");
//        }
//        else{
//             System.out.println("Failed to purchase course !!!");
//        }
    }
}
