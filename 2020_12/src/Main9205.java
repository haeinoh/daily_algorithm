//https://www.acmicpc.net/problem/9205
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main9205 {
	public static int N, endX, endY;
	public static Queue<Beer> q;
	public static List<Beer> list;
	
	public static class Beer {
		int x;
		int y;

		public Beer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void solve() {
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int ts = 1; ts <= test; ts++) {
			N = sc.nextInt();
			q = new LinkedList<>();
			list = new ArrayList<>();
			
			for(int i = 0; i < N+2; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
			}
			endX = sc.nextInt();
			endY = sc.nextInt();
			
		}
	}
}
