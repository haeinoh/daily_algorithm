//https://www.acmicpc.net/problem/9205
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main9205 {
	public static int N, dist[][]; // 0: �� , 1 - N : ������, N+1 : ����
	public static List<Beer> list;
	
	public static class Beer {
		int x;
		int y;

		public Beer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void floydWarshall() {
		for(int k = 0; k < N+2; k++) { // ���İ��� ������
			for(int i = 0; i < N+2; i++) { // �����
				for(int j = 0; j < N+2; j++) { // ��������
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int test = Integer.parseInt(st.nextToken().trim());
		
		for(int ts = 1; ts <= test; ts++) {
			st = new StringTokenizer(bf.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			dist = new int[N+2][N+2];
			
			for(int i = 0; i < N+2; i++) {
				st = new StringTokenizer(bf.readLine());				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Beer(x, y));
			}
			
			for(int i = 0; i < N+2; i++) { 
				for(int j = 0; j < N+2; j++) { 
					if(i != j) dist[i][j] = 987654321; //init
				}
			}
			
			for(int i = 0; i < N+2; i++) {
				for(int j = 0; j < N+2; j++) { // ���������� �Ÿ� ���ϱ�
					if(i != j) {
						int res = Math.abs(list.get(i).x - list.get(j).x) 
								+ Math.abs(list.get(i).y - list.get(j).y);
						if(res <= 1000) dist[i][j] = res;
					}
				}
			}
			
			floydWarshall();
			if(dist[0][N+1] > 0 && dist[0][N+1] != 987654321) System.out.println("happy");
			else System.out.println("sad");
		}
	}
}
