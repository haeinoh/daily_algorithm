//https://www.acmicpc.net/problem/1113
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1113 {
	public static int N, M, answer, maxHeight, arr[][];
	public static Queue<int[]> q;
	public static int vtd[][];
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
		
	public static void init() {
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < M; j++)
				vtd[i][j] = 0;
	}
	
	public static void solve(int value, int ee) {
		while(!q.isEmpty()) {
			int tmp[] = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1) continue;
				else if(vtd[nx][ny] == 0 && arr[nx][ny] < value){
					vtd[nx][ny] = ee;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		answer = 0;
		maxHeight = -987654321;
		arr = new int[N][M];
		vtd = new int[N][M];
		q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
				if(maxHeight < arr[i][j]) maxHeight = arr[i][j];
			}
		}

		for(int p = 2; p <= maxHeight; p++) {
			init();
			int tmp = 1;
			for(int i = 1; i < N-1; i++) {
				for(int j = 1; j < M-1; j++) {
					if(arr[i][j] < p && vtd[i][j] == 0) { //p의 높이보다 낮은 높이이면서 방문한 적이 없는 칸
						vtd[i][j] = tmp;
						q.add(new int[] {i, j});
						solve(p, tmp);
						tmp++;
					}
				}
			}
			for(int i = 1; i < N-1; i++) {
				for(int j = 1; j < M-1; j++) {
					if(vtd[i][j] != 0) {
						System.out.println(i + " " + j);
						answer++;
					}
				}
			}
			for(int i[]: arr)
				System.out.println(Arrays.toString(i));
			System.out.println("answer : " + answer);
			System.out.println();
			
		}
		
		System.out.println(answer);
	}
}
