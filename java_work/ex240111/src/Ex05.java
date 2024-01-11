import java.util.Arrays;

/*
    String
    성적관리 프로그램
    번호 이름 국어 영어 수학
    [0]["홍길동"][100],[80],[90]
    [1]["이길동"][70],[90],[100]
    [2]["박길동"][80],[70],[200]
 */
public class Ex05 {
    public static void main(String[] args) {
        String[] student1 = {"홍길동", "80", "90", "100"};
        String[] student2 = {"이길동", "70", "60", "80"};
        String[] student3 = {"박길동", "100", "90", "40"};

        String[][] all = {student1, student2, student3};

        System.out.println("학생의 숫자 = " + all.length + "명");

// System.out.println((all[0][1]+all[1][1]+all[2][1])/all.length);
        // System.out.println((all[0][2]+all[1][2]+all[2][2])/all.length);
        // System.out.println((all[0][3]+all[1][3]+all[2][3])/all.length);
        int korsum = 0;
        int engsum = 0;
        int mathsum = 0;


        for (int i = 0; i < all.length; i++) {
            korsum += Integer.parseInt(all[i][1]);
            engsum += Integer.parseInt(all[i][2]);
            mathsum += Integer.parseInt(all[i][3]);
        }

        System.out.println("국어점수의 총합=" + korsum);
        System.out.println("국어점수의 평균=" + korsum / all.length);

        System.out.println("영어점수의 총합=" + engsum);
        System.out.println("영어점수의 평균=" + engsum / all.length);

        System.out.println("수학점수의 총합=" + mathsum);
        System.out.println("수학점수의 평균=" + mathsum / all.length);

        System.out.println("모든점수의 평균");
        System.out.println((korsum + engsum + mathsum) / 9);
        // 학생의 숫자
        // 국어평균점수
        // 영어평균점수
        // 수학평균점수
        // 모든 점수의 평균점수
        // 1,2,3등 구하기

        int student_total[] = new int[3];

        // all[0][1] + all[0][2]+all[0][3]
        // all[1][1] + all[1][2]+all[1][3]
        // all[2][1] + all[2][2]+all[2][3]

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                student_total[i] += Integer.parseInt(all[i][j]);
            }
        }

        System.out.println(Arrays.toString(student_total));


    }
}


