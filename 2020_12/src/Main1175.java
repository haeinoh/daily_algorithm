//https://www.acmicpc.net/problem/1175
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1175 {
	public static int N, M, answer, baedal[][];
	public static char arr[][];
	public static boolean flag, vtd[][][][];
	public static Queue<Person> q;
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	
	public static class Person {
		int x;
		int y;
		int dir;
		int g;
		public Person(int x, int y, int dir, int g) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.g = g;
		}
	}
	public static void solve() {
		int count  = 0;
		loop:while(!q.isEmpty()) {
			int size = q.size();
			while(size > 0) {
				Person tmp = q.poll();
				int x = tmp.x;
				int y = tmp.y;
				int dir = tmp.dir;
				int g = tmp.g;
				if(x == baedal[0][0] && y == baedal[0][1]) { // 1번 C
					if(g != 1) g += 1;
				} else if(x == baedal[1][0] && y == baedal[1][1]) { // 2번 C
					if(g != 2) g += 2;
				}
				if(g == 3) {
					flag = true;
					answer = count;
					break loop;
				}
				for(int i = 0; i < 4; i++) {
					if(i != dir) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '#' ) continue;
						else if(!vtd[nx][ny][i][g]){
							q.add(new Person(nx, ny, i, g));
							vtd[nx][ny][i][g] = true;
						}
					}
				}				
				size--;
			}
			count++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		baedal = new int[2][2];
		vtd = new boolean[N][M][4][4]; // N / M / dir / baedal (1+2 => 3)
		q = new LinkedList<>();
		answer = 0;
		flag = false;
		
		int temp = 0; // 배달 array 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			String str = st.nextToken();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'S') {
					for(int k = 0; k < 4; k++) {
						q.add(new Person(i, j, k, 0));
						vtd[i][j][k][0] = true;
					}
				}
				if(arr[i][j] == 'C') {
					baedal[temp][0] = i;
					baedal[temp][1] = j;
					temp++;
				}
			}
		}
		
		solve();
		
		if(!flag) answer = -1;
		System.out.println(answer);
	}
}
