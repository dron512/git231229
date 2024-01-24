package org.example;

class ParentAdder{
    public void add(int num1,int num2){
        System.out.println("합 "+(num1+num2));
    }
}
class ChildAdder extends ParentAdder{
    @Override
    public void add(int num1, int num2) {
        System.out.println("덧셈을 진행합니다.");
        super.add(num1, num2);
    }
}

public class Main2 {
    public static void main(String[] args) {
        ChildAdder ca = new ChildAdder();
        ca.add(10,20);
    }
}
