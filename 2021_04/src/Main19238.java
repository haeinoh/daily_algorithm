import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main19238 {
	public static class Taxi {
		int sx;
		int sy;
		int dx;
		int dy;
		public Taxi(int sx, int sy, int dx, int dy) {
			this.sx = sx;
			this.sy = sy;
			this.dx = dx;
			this.dy = dy;
		}

		public Taxi() {

		}
	}
	public static int N, M, K, xx, yy;
	public static int[][] arr;
	public static Taxi[] taxi;
	public static LinkedList<Integer>[][] person;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};

	public static boolean check() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(person[i][j].size() > 0) return true;

		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		person = new LinkedList[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				person[i][j] = new LinkedList<>();
			}
		} 
		
		st = new StringTokenizer(bf.readLine()); // start pos
		xx = Integer.parseInt(st.nextToken())-1;
		yy = Integer.parseInt(st.nextToken())-1;
	
		taxi = new Taxi[M];
		// init
		for(int i = 0; i < M; i++) taxi[i] = new Taxi();
		// M
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int sx = Integer.parseInt(st.nextToken())-1;
			int sy = Integer.parseInt(st.nextToken())-1;
			int dx = Integer.parseInt(st.nextToken())-1;
			int dy = Integer.parseInt(st.nextToken())-1;
			person[sx][sy].add(i);
			taxi[i].sx = sx;
			taxi[i].sy = sy;
			taxi[i].dx = dx;
			taxi[i].dy = dy;
		}
	
		// fuel .. exist
		loop:while(K >= 0) {
			if(!check()) break;
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{xx, yy});
			int level = 0;
			boolean[][] vtd = new boolean[N][N];
			List<Integer> nextList = new ArrayList<>();
			while(!q.isEmpty()) {
				int size = q.size();
				while(size > 0) {
					int[] tmp = q.poll();
					int x = tmp[0];
					int y = tmp[1];
					vtd[x][y] = true;

					if(person[x][y].size() > 0) {
						nextList.add(person[x][y].get(0));
					}

					for(int p = 0; p < 4; p++) {
						int nx = x + dx[p];
						int ny = y + dy[p];

						if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 1) continue;
						else if(!vtd[nx][ny]) {
							q.add(new int[]{nx, ny});
						}
					}

					size--;
				}
				if(nextList.size() > 0) break;
				level++;
			}

			int next = 987654321;
			if(nextList.size() == 0) break loop; // 갈 수 있는 곳이 없다면,,
			for(int i = 0; i < nextList.size(); i++) {
				if(next > taxi[nextList.get(i)].sx) next = nextList.get(i);
			}

			Queue<int[]> qq = new LinkedList<>();
			K -= level; // xx -> start
			if(K < 0) break loop;
			qq.add(new int[] {taxi[next].sx, taxi[next].sy, K});
			vtd = new boolean[N][N];
			while(!qq.isEmpty()) { // start pos -> dest pos
				int[] tmp = qq.poll();
				int x = tmp[0];
				int y = tmp[1];
				int cnt = tmp[2];
				vtd[x][y] = true;
				if(cnt < 0) break loop;
				if(x == taxi[next].dx && y == taxi[next].dy) {
					// fuel .. exist .. remove from list
						xx = taxi[next].dx;
						yy = taxi[next].dy;
						person[taxi[next].sx][taxi[next].sy].remove();
						int temp = (K-cnt);
						K = cnt;
						K += temp * 2;
						break;
				}

				for(int p = 0; p < 4; p++) {
					int nx = x + dx[p];
					int ny = y + dy[p];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 1) continue;
					if(!vtd[nx][ny]) {
						qq.add(new int[] {nx, ny, cnt-1});
					}
				}
			}
			
		}
		
		if(check()) System.out.println("-1");
		else System.out.println(K);
	}
}
