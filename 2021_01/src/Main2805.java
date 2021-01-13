//https://www.acmicpc.net/problem/2805
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2805 {
	public static int N;
	public static long M, answer, arr[];

	public static boolean check(long num) {
		long sum = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i] - num > 0) sum += (arr[i] - num);
		}
		if(sum >= M ) {
			if(num >= answer) answer = num;
			return true;
		}
		return false;
	}

	public static void solve() {
		long left = 0;
		long right = arr[N-1];
		while(left <= right) {
			long mid = (left + right) / 2;
			if(check(mid)) left = mid+1;
			else right = mid-1;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());

		arr = new long[N];
		answer = 0;

		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		solve();

		System.out.println(answer);
	}
}