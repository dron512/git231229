package aa.bb;

import java.util.Scanner;

public class BB {

    // 메서드는... 변수선언과 수행문으로 이루어져있다.
    // doA 함수는 하는 일이 i를 0부터 9까지 출력한다.
    // doA 함수에서 a와 b를 입력받아 a,b 출력해라
    public void doA(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }

}
