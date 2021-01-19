//https://www.acmicpc.net/problem/1644
import java.util.ArrayList;
import java.util.Scanner;

public class Main1644 {
	public static int N, arr[];
	public static ArrayList<Integer> list;
	
	public static void solve() {
		arr[0] = 1;
		arr[1] = 1;
		for(int i = 2; i <= N; i++) {
			for(int k = 2; (i * k) <= N; k++) {
				if(arr[i*k] == 0) {
					arr[i*k] = 1;
				}
			}
		}
		for(int i = 0; i <= N; i++) {
			if(arr[i] == 0) {
				list.add(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		list = new ArrayList<>();
		solve();
		int start = 0;
		int end = 0;
		int count = 0;
		int sum = 0;
		
		while(start < list.size()) {
			if(sum >= N) {
				sum -= list.get(start++);
			} else if(end == list.size()) break;
			else {
				sum += list.get(end++);
			}
			if(sum == N) {
				count++;
			}
		}

		System.out.println(count);
	}
}
