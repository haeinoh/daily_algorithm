import java.util.LinkedList;
import java.util.Queue;

public class Solution72415 {
	public static class Card {
		int r;
		int c; 
		int ox;
		int oy;
		boolean flag;
		int arr[][];
		public Card(int r, int c, int[][] arr, boolean flag) {
			this.r = r;
			this.c = c;
			this.arr = arr;
			this.flag = flag;
		}
		
		public Card(int r, int c, int ox, int oy, int[][] arr, boolean flag) {
			this.r = r;
			this.c = c;
			this.ox = ox;
			this.oy = oy;
			this.arr = arr;
			this.flag = flag;
		}
	}
	public static int N ;
	public static Queue<Card> q;
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	public static boolean vtd[][];
	
	public static boolean done(int [][]b) {
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N; j++)
				if(b[i][j] == 0) return false;
		
		return true;
	}
	
	public static int calIndex(int point, int idx, int[][] b) {
		
		
		return 0;
	}
	
	
	public static int solution(int[][] board, int r, int c) {
        int answer = 0;
        N = 4;
        q = new LinkedList<>();
        q.add(new Card(r, c, -1, -1, board, false));
        vtd = new boolean[N][N];
        loop:while(!q.isEmpty()) {
        	int size = q.size();
        	while(size > 0) {
        		Card tmp = q.poll();
        		int x = tmp.r;
        		int y = tmp.c;
        		int ox = tmp.ox;
        		int oy = tmp.oy;
        		int arr[][] = tmp.arr;
        		boolean flag = tmp.flag;
        		if(done(arr)) break loop;
        	
        		// 4 ���� �������� �ܼ� �̵�
        		for(int i = 0; i < 4; i++) {
        			int nx = x + dx[i];
        			int ny = y + dy[i];
        			
        			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        			if(vtd[nx][ny] != flag) {
        				q.add(new Card(nx, ny, ox, oy, arr, flag));
        				vtd[nx][ny] = flag;
        			}
        		}
        		
        		for(int i = 0; i < 4; i++) {
        			
        		
        		}
        		
        		if(ox == -1 && oy == -1) {
        			ox = x;
        			oy = y;
        			
        		} else {
        			if(arr[ox][oy] == arr[x][y]) {
        				arr[ox][oy] = 0;
        				arr[x][y] = 0;
        				q.add(new Card(x, y, -1, -1, arr, flag));
        			} else {
        				q.add(new Card(x, y, -1, -1, arr, flag));
        			}
        		}
        		
        	}
        	answer++;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int bo[][] = {
			{1,0,0,3},
			{2,0,0,0},
			{0,0,0,2},
			{3,0,1,0}	
		};
		
		int r = 1;
		int c = 0;
		
		System.out.println(solution(bo, r, c));
	}
}
