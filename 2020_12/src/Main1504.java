import java.util.Scanner;

public class Main1504 {
	public static int N, E, v1, v2, dist[], arr[][];
	public static int INF = 987654321;
	public static boolean vtd[];
	public static class Pair implements Comparable<Pair>{
		int v;
		int d;

		public Pair(int v, int d) {
			this.v = v;
			this.d = d;
		}
		
		@Override
		public int compareTo(Pair o) {
			return d - o.d;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		
		arr = new int[N][N];
		vtd = new boolean[N];
		dist = new int[N];
		
		for(int i = 0; i < N; i++) dist[i] = INF;
		
		for(int i = 0; i < E; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			arr[a][b] = c;
			arr[c][b] = c;
		}
		v1 = sc.nextInt();
		v2 = sc.nextInt();
		
		
	}
}
