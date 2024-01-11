public class Ex04 {

    public static void main(String[] args) {

        int[][] score = {{10, 20, 30, 50, 60}, {40, 50, 60}, {70, 80, 90, 100}};


        // 모든 수의 합을 구하시오
        int sum = 0;
        // i = 0 j = 0~2
        // i = 1 j = 0~2
        // i = 2 j = 0~2
//        sum = score[0][0]+score[0][1]+score[0][2]+
//                score[1][0]+score[1][1]+score[1][2]+
//                score[2][0]+score[2][1]+score[2][2];
//
//        System.out.println(sum);

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                sum += score[i][j];
            }
        }
        System.out.println(sum);
    }
}
