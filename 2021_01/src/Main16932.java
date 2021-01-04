//https://www.acmicpc.net/problem/16932
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main16932 {
	public static int N, M, arr[][], check[][], save[], answer, length;
//	public static boolean vtd[];
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	public static Queue<int[]> q;
	public static HashSet<Integer> set;
	
	public static void make(int num) {
		while(!q.isEmpty()) {
			int tmp[] = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i = 0 ;i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(arr[nx][ny] == 1 && check[nx][ny] == 0){
					check[nx][ny] = num;
					q.add(new int[] {nx, ny});
					save[num]++;
				}
			}
		}
	}
	
	public static void solve(int x, int y) {
		int count = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			if(check[nx][ny] > 0 && !set.contains(check[nx][ny])/*!vtd[check[nx][ny]]*/) {
//				vtd[check[nx][ny]] = true;
				set.add(check[nx][ny]);
				count += save[check[nx][ny]];
			}
		}
		if(count > 1) count++;
		if(answer < count) answer = count;
	}
	
//	public static void init() {
//		for(int i = 1; i <= length; i++) vtd[i] = false;
//	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		check = new int[N][M];
		save = new int[N*M];
		answer = 0;
		q = new LinkedList<int[]>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int number = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 1 && check[i][j] == 0) {
					check[i][j] = number;
					save[number]++;
					length++;
					q.add(new int[] {i, j});
					make(number);
					number++;
					length = number;
				}
			} 
		}
//		vtd = new boolean[length+1];
		set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
//					init();
					set.clear();
					solve(i, j);
				}
			}
		}
		
		System.out.println(answer);
	}
}
