package org.example.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ExeCalculator{

    public void doPrint() {
        System.out.println("테스트 메서드 입니다.시작");
        Stream.of(11,22,33,44,55,66,77,88,99,100)
                .forEach(System.out::println);
        System.out.println("테스트 메서드 입니다.종료");
    }
}
