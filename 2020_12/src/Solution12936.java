//https://programmers.co.kr/learn/courses/30/lessons/12936
import java.util.ArrayList;
import java.util.Arrays;

public class Solution12936 {
	public static int n;
	public static long k; // test용
	public static ArrayList<Integer> list;
	public static long fact[], fa;

	public static void init(int num) { // factorial 계산
		fact[1] = 1;
		fact[2] = 2;
		
		for(int i = 3; i <= num; i++) {
			fact[i] = i * fact[i-1];
		}
	}

	public static void main(String[] args) {
		n = 4;
		k = 10;
		int answer[] = new int[n];
		fact = new long[n+1];
		list = new ArrayList<>();
		for(int i = 1; i <= n; i++) list.add(i);
		init(n);
		
		long start = k-1; //k가 한 블럭의 마지막일 경우 다른 블럭으로 잡힘 
		for(int i = 1; i < n; i++) {
			int idx = (int) (start / fact[n-i]); 
			answer[i-1] = list.get(idx);
			list.remove(idx);
			start %= (fact[n-i]);
		}
		
		answer[n-1] = list.get(0);
		System.out.println(Arrays.toString(answer)); // test용
	}
}
