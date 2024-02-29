package org.example.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ExeCalculator implements Calculator{

    private Calculator dele;

    @Override
    public void doPrint() {
        //        calcu.doPrint();
        Stream.of(11,22,33,44,55,66,77,88,99,100)
                .forEach(System.out::println);

    }
}
