package org.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main7 {

    public static void main(String[] args) {
        GenericXmlApplicationContext gxac
                = new GenericXmlApplicationContext("aa.xml");
        Count aa = gxac.getBean(Count.class);
        System.out.println(aa);
        Count aa1 = gxac.getBean(Count.class);
        System.out.println(aa1);
        Count aa2 = gxac.getBean(Count.class);
        System.out.println(aa2);
    }
}
