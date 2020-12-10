//https://www.acmicpc.net/problem/1915
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1915 {
	public static int N, M, answer, arr[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		answer = 0;
		boolean flag = false;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			String str = st.nextToken();
			for(int j = 0; j < str.length(); j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
				if(arr[i][j] == 1) flag = true;	
			}
		}
		if(N == 1 || M == 1) {
			if(flag) answer = 1;
		} else {
			for(int i = 1; i < N; i++) {
				for(int j = 1; j < M; j++) {
					if(arr[i][j] == 1) {
						arr[i][j] = Math.min(arr[i-1][j], Math.min(arr[i-1][j-1], arr[i][j-1])) + 1;
						if(arr[i][j] >= answer) answer = arr[i][j];
					}
				}
			}
		}
		System.out.println(answer*answer);
	}
}
