//https://www.acmicpc.net/problem/16234
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16234 {
	public static int N, L, R, people, count, answer, arr[][];
	public static boolean flag, vtd[][];
	public static Queue<int[]> q, f;
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	
	public static void solve() {
		while(!q.isEmpty()) {
			int tmp[] = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				else if(!vtd[nx][ny] && (Math.abs(arr[nx][ny] - arr[x][y]) >= L) && 
						Math.abs(arr[nx][ny] - arr[x][y]) <= R) {
					q.add(new int[] {nx, ny});
					f.add(new int[] {nx, ny});
					people += arr[nx][ny];
					vtd[nx][ny] = true;
					count++;
					flag = true;
				}
			}
		}
		if(flag) {
			open();
		}
	}
	
	public static void open() {
		int num = people/count;
		while(!f.isEmpty()) {
			int tmp[] = f.poll();
			int x = tmp[0];
			int y = tmp[1];
			arr[x][y] = num;
		}
	}
	
	public static void init() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) 
				vtd[i][j] = false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		arr = new int[N][N];
		vtd = new boolean[N][N];
		q = new LinkedList<int[]>();
		f = new LinkedList<int[]>();
		answer = 0;
		
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N; j++) 
				arr[i][j] = sc.nextInt();
		
		loop:while(true) {
			flag = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!vtd[i][j]) {
						people = 0;
						count = 1;
						vtd[i][j] = true;
						q.add(new int[] {i, j});
						f.add(new int[] {i, j});
						people += arr[i][j];
						solve();
						f.clear();
					}
				}
			}
			if(flag) answer++;
			else break loop;
			init();
		}
		System.out.println(answer);
	}
}
