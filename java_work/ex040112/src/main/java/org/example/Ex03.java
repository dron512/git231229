package org.example;

import java.util.Scanner;

class AA{
    public void doA(){}
}
class BB{}
class CC{}
public class Ex03 {

    public static void main(String[] args) {
        AA a = new AA();
        Scanner scan = new Scanner(System.in);
        Integer i = new Integer(10);
        // 10진수를 2진수 바꾸는 함수 사용.. 10 -> 1010
        // 모르는부분은 모르는데로.. 생각하고..
        // java 어떻게
        // java 를 사용해서 프로그램을 만들수 있냐 없냐..
        String binString = Integer.toBinaryString(i);
        System.out.println(binString);

        //10진수가 주어졌을때 2진수로 바꿀수 있냐없냐..
    }
}
