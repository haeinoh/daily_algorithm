import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main9372 {
	public static int N, M, answer;
	public static List<List<Integer>> list;
	public static boolean vtd[];
	
	public static void init() {
		for(int i = 0; i < N; i++) {
			vtd[i] = false;
			list.add(new ArrayList<>());
		}
	}
	
	public static int solve(int start) {
		int count = 1;
		int ans = 0;
		
		while(count != N) {

			for(int i = 0; i < N; i++) {
				if(list.get(start).get(i) != null) {
					
					
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		vtd = new boolean[1002];
		list = new ArrayList<>();

		for(int ts = 1; ts <= test; ts++) {
			N = sc.nextInt();
			M = sc.nextInt();
			init();
			answer = 987654321;
			for(int i = 0; i < M; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			for(int i = 0; i < N; i++) {
				answer = Math.min(solve(i), answer);
			}
			System.out.println(answer);
		}
	}
}
