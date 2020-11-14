import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1303 {
	public static int N, M, white, blue, arr[][];
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	public static Queue<int[]> q;
	public static boolean vtd[][];
	
	public static void solve(int num) {
		int answer = 1;
		while(!q.isEmpty()) {
			int tmp[] = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(!vtd[nx][ny] && arr[nx][ny] == num) {
					q.add(new int[] {nx, ny});
					vtd[nx][ny] = true;
					answer += 1;
				}
			}
			
		}
		if(num == 0) white += (answer*answer);
		else blue += (answer*answer);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		q = new LinkedList<int[]>();
		vtd = new boolean[N][M];
		white = 0;
		blue = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			String str = st.nextToken();
			for(int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				arr[i][j] = (ch == 'W') ? 0 : 1;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!vtd[i][j]) {	
					q.add(new int[] {i, j});
					vtd[i][j] = true;
					solve(arr[i][j]);
				}
			}
		}
		System.out.println(white + " " + blue);
	}
}
