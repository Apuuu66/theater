package com.ttms.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

public class BeanFactory {
    public static Object getBean(String id) throws Exception {
        //通过id获取一个指定的实现类
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        Document doc = new SAXReader().read(in);
        Element ele = (Element) doc.selectSingleNode(String.format("//bean[@id='%s']", id));
        String value = ele.attributeValue("class");

        return Class.forName(value).newInstance();
    }

//    public static void main(String[] args) throws Exception {
//
//        System.out.println(getBean("ProductDao"));
//        System.out.println(getBean("UserDao"));
//        System.out.println(getBean("CategoryDao"));
//        System.out.println(getBean("CategoryService"));
//    }
}
