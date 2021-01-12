import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1654 {
	public static int N, K;;
	public static long arr[], answer;
	
	public static boolean check(long num) {
		int count = 0;
		for(int i = 0; i < K; i++) {
			count += (arr[i] / num);
		}
		
		if(count >= N) {
			answer = num;
			return true;
		}
		
		return false;
	}
	
	public static void solve() { 
		long left = 1;
		long right = arr[K/2];
		long mid = (left+right)/2;
		
		while(left <= right) {
			if(!check(mid)) {
				right = mid-1;
			} else {
				left = mid+1;
			}
			mid = (left+right)/2;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new long[K];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine().trim());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		answer = 0;
		Arrays.sort(arr);
		solve();
		System.out.println(answer);
	}
}
