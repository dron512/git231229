import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex08 {

    public static int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while(n!=1) {
            if (n % 2 == 0) {
                list.add(n = n / 2);
            } else {
                list.add(n = 3 * n + 1);
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        solution(10);
    }
}
