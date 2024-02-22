package org.example;

import org.example.component.AA;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {

    public static void main(String[] args) {

        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext("myContext.xml");

        AA a1 = context.getBean(AA.class);
        AA a2 = context.getBean(AA.class);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1==a2);
        context.close();

    }

}
