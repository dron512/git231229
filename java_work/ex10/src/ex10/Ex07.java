package ex10;

import java.util.Arrays;

public class Ex07 {
	public static int[] solution(int[] arr, int[][] queries) {
        for (int i=0; i<queries.length;i++)
        	for(int j=queries[i][0];j<queries[i][1]+1;j++) {
        		if(j%queries[i][2]==0)
        			arr[j]++;
        	}
        return arr;
    }
	
	public static void main(String[] args) {
		int[] arr = solution(new int[] {0,1,2,4,3},new int[][] {{0,4,1},{0,3,2},{0,3,3}});
		System.out.println(Arrays.toString(arr));
	}
}
