import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2003 {
	public static int N, M, arr[], answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		answer = 0;
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = 0;
		int sum = 0;
		
		while(start < N) {
			if(sum >=M) sum -= arr[start++]; // sum이 M보다 커졌을 때, 새로운 현재 값을 빼주고, start를 한칸 앞으로 이동한다. 
			else if(end == N) break;
			else sum += arr[end++]; //(sum이 M보다 작을 떄) sum에 새로운 현재 값을 더해준 후, end 포인터를 한 칸 이동
			
			if(sum == M) answer++; // sum이 M과 같은 값일 때 
		}
		
		
		System.out.println(answer);
	}
}
