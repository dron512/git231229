package org.example;

/*
    javascript, python
    import java.lang.*;
    기본생성자 생략가능 -> 다른생성자 선언하면 기본생성자 생략불가
    super(); -> 생략가능
    toString(); -> 생략가능
 */
class MobilePhone{
    protected String number;
// 다른생성자 선언시 기본생성자 생략 불가..
//    public MobilePhone(){}
    public MobilePhone(String number) {
        this.number = number;
    }
    public void answer(){
        System.out.println("대답해따 번호는 "+number);
    }
}
class SmartPhone extends MobilePhone{
    private String androidVer;
    public SmartPhone(String number, String ver) {
        super(number);
        this.androidVer = ver;
    }
    public void playApp(){
        System.out.println("앱 실행함 안드로이드 버전은 = "+androidVer);
    }
}
public class Main2 {
    // 스마트폰은 모바일폰이다. is a 관계
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone("010-9946-2662","1.0");
        sp.playApp();
        sp.answer();

        // 부모객체     // 자식객체
        // 자식객체는 부모객체에 담을수있다.
        // 부모객체는 자식객체를 참조할수있다.
        // 다형성이라고 한다...
        MobilePhone mp = new SmartPhone("010-1234-1234","2.0");
        mp.answer();
//        mp.playApp();

    }
}















