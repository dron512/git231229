// 로또 만들기...
// 코드 리뷰 날짜
// 2주에 한번씩...

public class Main {

    public static void main(String[] args) {
        int[] lottoNumber = new int[100];

        // 입력하는 for
        // 1번째 부터 비교해라
        // 0번 ~ 현재번호까지 비교하면서 같은게 있으면 counter 증가해라
        // 똑같은게 없을때까지 해라
        // ctrl + alt + l 자동정렬
        int counter = -1;
        for (int i = 0; i < lottoNumber.length; i++) {
            lottoNumber[i] = (int) (Math.random() * 45) + 1;
            while(true) {
                counter = 0;
                for (int j = 0; j < i; j++) {
                    if (lottoNumber[i] == lottoNumber[j]) {
                        counter++;
                    }
                }
                System.out.println("counter = " + counter);
                if (counter > 0) {
                    lottoNumber[i] = (int) (Math.random() * 45) + 1;
                }
                else{
                    break;
                }
            }
        }

        // 출력하는 for
        for (int i = 0; i < lottoNumber.length; i++) {
            System.out.print(lottoNumber[i] + " ");
        }

    }
}