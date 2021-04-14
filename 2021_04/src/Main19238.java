import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
	}
	public static int N, M, xx, yy;
	public static long K;
	public static int[][] arr;
	public static Taxi[] taxi;
	public static ArrayList<Integer> list;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		
		st = new StringTokenizer(bf.readLine()); // start pos
		xx = Integer.parseInt(st.nextToken());
		yy = Integer.parseInt(st.nextToken());
	
		taxi = new Taxi[N];
		list = new ArrayList<>();
		// init
		for(int i = 0; i < M; i++) taxi = new Taxi[i];
		// M
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			
			taxi[i].sx = sx;
			taxi[i].sy = sy;
			taxi[i].dx = dx;
			taxi[i].dy = dy;
			list.add(i);
		}
	
		// fuel .. exist
		loop:while(K >= 0) {
			int[] count = new int[list.size()];
			
			for(int i = 0; i < list.size(); i++) {
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] {xx, yy, 0});
				boolean[][] vtd = new boolean[N][N];
				
				while(!q.isEmpty()) { // taxi start pos -> each pp start pos
					int[] tmp = q.poll();
					int x = tmp[0];
					int y = tmp[1];
					int cnt = tmp[2];
					vtd[x][y] = true;
					
					if(xx == taxi[list.get(i)].sx && yy == taxi[list.get(i)].sy) {
						count[i] = cnt;
						break;
					}
					
					for(int p = 0; p < 4; p++) {
						int nx = x + dx[p];
						int ny = y + dy[p];
						
						if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 1) continue;
						if(!vtd[nx][ny]) {
							q.add(new int[] {nx, ny, cnt+1});
						}
					}
				}
			}
			
			int next = 0;
			int num = 987654321;
			
			for(int i = 0; i < count.length; i++) {
				if(num > count[i]) {
					num = count[i];
					next = i;
				} else if(num == count[i]) {
					if(taxi[next].sx > taxi[i].sx) next = i;
				}
			}
			
			Queue<int[]> qq = new LinkedList<>();
			qq.add(new int[] {taxi[next].sx, taxi[next].sy, 0});
			boolean[][] vtd = new boolean[N][N];
			K -= count[next]; // xx -> start 
			while(!qq.isEmpty()) { // start pos -> dest pos
				int[] tmp = qq.poll();
				int x = tmp[0];
				int y = tmp[1];
				int cnt = tmp[2];
				vtd[x][y] = true;
				
				if(x == taxi[list.get(next)].dx && y == taxi[list.get(next)].dy) {
					K -= cnt;
					if(K >= 0) { // fuel .. exist .. remove from list
						xx = taxi[list.get(next)].dx;
						yy = taxi[list.get(next)].dy;
						list.remove(next);
						K += cnt*2;
						break;
					} else break loop; 
				}
				
				for(int p = 0; p < 4; p++) {
					int nx = x + dx[p];
					int ny = y + dy[p];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 1) continue;
					if(!vtd[nx][ny]) {
						qq.add(new int[] {nx, ny, cnt+1});
					}
				}
			}
			
		}
		
		if(list.size() > 0) System.out.println("-1");
		else System.out.println(K);
	}
}
