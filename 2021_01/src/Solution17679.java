//https://programmers.co.kr/learn/courses/30/lessons/17679
public class Solution17679 {
	public static int N, M, answer;
	public static int dx[] = {0, 1, 1};
	public static int dy[] = {1, 0, 1};
	public static char arr[][];
	public static int map[][];
	public static boolean flag;
	
	public static void down() {
		for(int j = 0; j < M; j++) {
			loop:for(int i = N-1; i > 0; i--) {
				if(arr[i][j] == ' ') {
					for(int k = i-1; k >= 0; k--) {
						if(arr[k][j] != ' ') {
							arr[i][j] = arr[k][j];
							arr[k][j] = ' ';
							i--;
						}
					}
					break loop;
				}
			}
		}
		
	}
	
	public static void bomb() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > 0) {
					answer++;
					arr[i][j] = ' ';
				}
			}
		} 
	}
	
	public static void solve(int x, int y, int num) {
		int count = 0;
		for(int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if(arr[nx][ny] == arr[x][y]) {
				count++;
			}
		}
		
		if(count == 3) {
			map[x][y] = num;
			for(int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				map[nx][ny] = num;
			}
			flag = true;
		}
	}
	
	public static void init() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				map[i][j] = 0;
	}
	
	public static  int solution(int m, int n, String[] board) {
		answer = 0;
		N = m;
		M = n;
		arr = new char[N][M];
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = board[i].charAt(j);
			}
		}
		
		while(true) {
			flag = false;
			int num = 1;
			init();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] != ' ') {
						solve(i, j, num++);
					}
				}
			}
			
			if(!flag) break;
			else {
				bomb();
				down();
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		String[] bo = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(6, 6, bo));
	}
}
