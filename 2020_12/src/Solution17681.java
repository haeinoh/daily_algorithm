//https://programmers.co.kr/learn/courses/30/lessons/17681?language=java
import java.util.Arrays;

public class Solution17681 {

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			int x = arr1[i] | arr2[i];
			StringBuffer str = new StringBuffer();
			for(int j = 0; j < n; j++) {
				int tmp = x % 2;
				x /= 2;
				str.append((tmp == 1) ? "#" : " ");
			}
			answer[i] = str.reverse().toString();
		}
		return answer;
	}

	public static void main(String[] args) {
		int a[] = {46, 33, 33 ,22, 31, 50};
		int b[] = {27 ,56, 19, 14, 14, 10 };
		System.out.println(Arrays.toString(solution(6, a, b)));
	}
}
