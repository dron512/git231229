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

            if(value.contains("0") || value.contains("5")) {
                if( !value.contains("1") && !value.contains("2")
                        && !value.contains("3")
                        && !value.contains("4")
                        && !value.contains("6")
                        && !value.contains("7")
                        && !value.contains("8")
                        && !value.contains("9")
                        ) {
                    list.add(Integer.parseInt(value));
                }

            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        new Ex06();
    }
}

