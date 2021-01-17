//https://programmers.co.kr/learn/courses/30/lessons/60062
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution60062 {
	public static int di[], we[], arr[], answer;
	public static boolean vtd[];
	public static List<Integer> list;
	
	public static void friends() {
		int count = 0; // Ä£±¸ ¼ö
		int check = 0;
		int prev = 0;
		loop: for (int k = 0; k < arr.length; k++) {
			if (prev >= we.length)
				break;
			int num = list.get(prev) + di[arr[k]];
			for (int p = prev; p < we.length; p++) {
				if (list.get(p) <= num) {
					check++;
					if (p == we.length - 1) {
						count++;
						break loop;
					}
				} else {
					prev = p;
					break;
				}
			}
			count++;
		}

		if (check == we.length) {
			answer = Math.min(answer, count);
		}
	}
	
	public static void solve(int cnt) {
		if(cnt == di.length) {
			friends();
			return; 
		}
		
		for(int i = 0; i < di.length; i++) {
			if(!vtd[i]) {
				vtd[i] = true;
				arr[cnt] = i;
				solve(cnt+1);
				vtd[i] = false;
			}
		}
	}
	
	public static int solution(int n, int[] weak, int[] dist) {
		answer = 987654321;
		di = dist;
		we = weak;
		arr = new int[dist.length];
		vtd = new boolean[dist.length];
		Arrays.sort(dist);
		
		for (int i = 0; i < weak.length; i++) {
			list = new ArrayList<>();
			// make
			for (int j = i; j < i + weak.length; j++) {
				if (j < weak.length)
					list.add(weak[j]);
				else {
					list.add(weak[j - weak.length] + n);
				}
			}
			solve(0);
		}

		if (answer == 987654321)
			return -1;
		return answer;
	}

	public static void main(String[] args) {
//		int n = 12;
		int n = 200;
//		int w[] = {1, 5, 6, 4};
//		int d[] = {1, 2, 3, 4};
//		int w[] = {1, 3, 4, 9, 10};
//		int d[] = {3, 5, 7};
		int w[] = { 0, 10, 50, 80, 120, 160 }; // 6, 10, 12, 14
		int d[] = { 1, 10, 5, 40, 30 };

		System.out.println(solution(n, w, d));
	}
}
