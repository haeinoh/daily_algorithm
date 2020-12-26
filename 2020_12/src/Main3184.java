//https://www.acmicpc.net/problem/3184
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3184 {
	public static int R, C, sheep, wolf;
	public static char arr[][]; // # : 울타리 , o : 양, v : 늑대, . : 필드
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	public static Queue<int[]> q;
	public static boolean vtd[][];
	
	public static void solve() {
		int tmpSheep = 0;
		int tmpWolf = 0;
		while(!q.isEmpty()) {
			int tmp[] = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= R || ny >= C || arr[nx][ny] == '#') continue;
				else if(!vtd[nx][ny]) {
					if(arr[nx][ny] == 'o') tmpSheep++;
					else if(arr[nx][ny] == 'v') tmpWolf++;
					
					q.add(new int[] {nx, ny});
					vtd[nx][ny] = true;
				}
			}
		}
		
		if(tmpSheep > tmpWolf) sheep += tmpSheep;
		else wolf += tmpWolf;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		vtd = new boolean[R][C];
		q = new LinkedList<int[]>();
		sheep = 0;
		wolf = 0;
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(bf.readLine());
			String str = st.nextToken();
			for(int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(arr[i][j] == '#' && !vtd[i][j]) {
					q.add(new int[] {i, j});
					vtd[i][j] = true;
					solve();
				}
			}
		}
		
		System.out.println(sheep + " " + wolf);
	}
}
