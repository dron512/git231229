package org.example;
class Man extends Object{
    private String name;
    Man(){
        System.out.println("Man 부모 생성자");
    }
    Man(String name){
        this.name = name;
    }
    public void yourName(){
        System.out.println("name = "+ name);
    }
}
class BusinessMan extends Man{
    private String company;
    private String position;
    BusinessMan(){
        super();
        System.out.println("기본생성자");
    }
    BusinessMan(String company, String position, String name){
        super(name);
        System.out.println("다른생성자");
        this.company = company;
        this.position = position;
    }

    public void yourInfo(){
        System.out.println( "company = "+ company );
        System.out.println( "position = "+ position );
        yourName();
    }
}
public class Main1 {
    // setter 
    // 생성자 초기화 방식
    public static void main(String[] args) {
        BusinessMan bm1 = new BusinessMan("그린컴퓨터학원","강사","홍길동");
        bm1.yourInfo();
    }

}
