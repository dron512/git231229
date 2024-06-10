package com.three.alcoholshoppingmall.project.test;


import com.three.alcoholshoppingmall.project.shoppingbasket.DetailbasketRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;




@SpringBootTest
public class Testcress {

    @Autowired
    private DetailbasketRepository detailbasketRepository;


    @Test
    void test(){

        String email = "aaa@naver.com";

    }
}
