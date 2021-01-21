//https://www.acmicpc.net/problem/1194
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1194 {
	static class Dal {
		int x;
		int y;
		int key;

		public Dal(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}

	public static int N, M, answer;
	public static char arr[][];
	public static Queue<Dal> q;
	public static boolean vtd[][][];
	public static int dx[] = { -1, 0, 1, 0 };
	public static int dy[] = { 0, -1, 0, 1 };

	public static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				Dal tmp = q.poll();
				int x = tmp.x;
				int y = tmp.y;
				int key = tmp.key;

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '1')
						continue;
					else if (!vtd[nx][ny][key]) {
						if (arr[nx][ny] == '.') {
							q.add(new Dal(nx, ny, key));
						} else if (arr[nx][ny] >= 'A' && arr[nx][ny] <= 'Z') {

						} else if (arr[nx][ny] >= 'a' && arr[nx][ny] <= 'z') {

						}
					}
				}
				size--;
			}
			answer++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		q = new LinkedList<>();
		vtd = new boolean[N][M][22];
		answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == '0') {
					q.add(new Dal(i, j, 0));
				}
			}
		}

		solve();
		System.out.println(answer);
	}
}
