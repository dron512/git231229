import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex06 {

    public Ex06() {
        int[] arr = {0, 1, 2, 4, 3, 5, 6, 7};
        int[][] queries = {{0, 4, 2}, {0, 3, 1}, {0, 2, 6}};
        solution(5, 555);
    }

    // 문제풀이...

    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = l; i < r+1; i++) {
            String value = String.valueOf(i);

            if(value.contains("0") && value.contains("5")) {
                list.add(Integer.parseInt(value));
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void main(String[] args) {
        new Ex06();
    }
}
