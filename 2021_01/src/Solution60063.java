import java.util.LinkedList;
import java.util.Queue;

public class Solution60063 {
	static class Dot {
		int x;
		int y;
		int a;
		int b;
		public Dot(int x, int y, int a, int b) {
			this.x = x;
			this.y = y;
			this.a = a;
			this.b = b;
		}
	}
	
	public static int bo[][], answer, N;
	public static boolean vtd[][][][];
	public static Queue<Dot> q;
	public static int dx[] = {0, 1};
	public static int dy[] = {1, 0};
	
	public static void solve() {
		loop:while(!q.isEmpty()) {
			int size = q.size();
			while(size > 0) {
				Dot tmp = q.poll();
				int x1 = tmp.x;
				int y1 = tmp.y;
				int x2 = tmp.a;
				int y2 = tmp.b;
				if((x1 == N-1 && y1 == N-1) || (x2 == N-1 && y2 == N-1)) {
					break loop;
				}
				
				for(int i = 0; i < 2; i++) {
					int nx1 = x1 + dx[i];
					int ny1 = y1 + dy[i];
					int nx2 = x2 + dx[i];
					int ny2 = y2 + dy[i];
					
					if(nx1 < 0 || ny1 < 0 || nx2 < 0 || ny2 < 0 || nx1 >= N 
							|| ny1 >= N || nx2 >= N || ny2 >= N || bo[nx1][ny1] == 1 || bo[nx2][ny2] == 1) continue;
					else if(!vtd[nx1][ny1][nx2][ny2]){
						q.add(new Dot(nx1, ny1, nx2, ny2));
						vtd[nx1][ny1][nx2][ny2] = true;
					}
				}
				
				//90도 회전 - 오른쪽 축 기준 (일직선)
				if(y1 < y2 && x1 == x2 && x1+1 < N && y1+1 < N && bo[x1+1][y1] == 0 && bo[x1+1][y1+1] == 0) {
					q.add(new Dot(x1+1, y1+1, x2, y2));
					vtd[x1+1][y1+1][x2][y2] = true;
				} else if(y2 < y1  && x1 == x2 && x2+1 < N && y2+1 < N && bo[x2+1][y2] == 0 && bo[x2+1][y2+1] == 0) {
					q.add(new Dot(x1, y1, x2+1, y2+1));
					vtd[x1+1][y1+1][x2][y2] = true;
				}

				// 90도 회전 - 왼쪽 축 기준
				if(y1 < y2 && x1 == x2 && x2+1 < N && y2-1 >= 0 && bo[x2+1][y2] == 0 && bo[x2+1][y2-1] == 0) {
					q.add(new Dot(x1, y1, x2+1, y2-1));
					vtd[x1][y1][x2+1][y2-1] = true;
				} else if (y2 < y1  && x1 == x2 && x1+1 < N && y1-1 >= 0 && bo[x1+1][y1] == 0 && bo[x1+1][y1-1] == 0) {
					q.add(new Dot(x1+1, y1-1, x2, y2));
					vtd[x1+1][y1-1][x2][y2] = true;
				}
				
				// 90도 회전 - 세로 일 때 (오른쪽으로)
				if(x1 > x2 && y1 == y2 && y2+1 < N && x2+1 < N && bo[x2][y2+1] == 0 && bo[x2+1][y2+1] == 0) {
					q.add(new Dot(x1, y1, x2+1, y2+1));
					vtd[x1][y1][x2+1][y2+1] = true;
				} else if(x1 < x2 && y1 == y2 && y1+1 < N && x1+1 < N && bo[x1][y1+1] == 0 && bo[x1+1][y1+1] == 0) {
					q.add(new Dot(x1+1, y1+1, x2, y2));
					vtd[x1+1][y1+1][x2][y2] = true;
				}
				size--;
			}
			answer++;
		}
	}
	
	public static int solution(int[][] board) {
		answer = 0;
		bo = board;
		N = bo.length;
		vtd = new boolean[N][N][N][N];
		q = new LinkedList<Dot>();
		q.add(new Dot(0,0,0,1));
		vtd[0][0][0][1] = true;
		solve();
		return answer;
	}
	public static void main(String[] args) {

		int b[][] = {
			{0, 0, 0, 1, 1},
			{0, 0, 0, 1, 0},
			{0, 1, 0, 1, 1},
			{1, 1, 0, 0, 1},
			{0, 0, 0, 0, 0}
		};
		System.out.println(solution(b));
	}
}
