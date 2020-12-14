//https://www.acmicpc.net/problem/1113
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1113 {
	public static int N, M, answer, value, arr[][], check[][];
	public static Queue<int[]> q;
	public static boolean vtd[][];
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};

	public static void solve() {
		while(!q.isEmpty()) {
			int tmp[] = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i = 0 ;i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if((nx == 0 && ny == 0) || (nx == 0 && ny == M-1) || 
						(nx == N-1 && ny == 0) || (nx == N-1 && ny == M-1)) continue;
				else if(nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
				else if(arr[nx][ny] <= arr[x][y]){
					System.out.println(nx + " " + ny);
					vtd[nx][ny] = true;
					if(check[nx][ny] == 0) {
						q.add(new int[] {nx, ny});						
						check[nx][ny] = 1;
					}
					check[x][y] = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		answer = 0;
		value = 987654321;
		arr = new int[N][M];
		check = new int[N][M];
		vtd = new boolean[N][M];
		q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		
		for(int i = 0 ;i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!vtd[i][j]) {
					q.add(new int[] {i, j});
					solve();
					vtd[i][j] = true;
				}
			}
		}
		
		for(int i[]: check) System.out.println(Arrays.toString(i));
		
		System.out.println(answer);
	}
}
