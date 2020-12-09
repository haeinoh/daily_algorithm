import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
	int y;
	int num;
	public Pair(int y, int num) {
		this.y = y;
		this.num = num;
	}
}

public class Main3176 {
	public static int N, K, depth[], dp[][], maxDp[][], minDp[][];
	public static List<List<Pair>> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		
		depth = new int[N+1];
		dp = new int[N+1][21];
		maxDp = new int[N+1][21];
		minDp = new int[N+1][21];
		
		list = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
		}
		
		st = new StringTokenizer(bf.readLine());
		K = Integer.parseInt(st.nextToken());
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
		}
		
	}
}
