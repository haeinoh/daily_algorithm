//https://www.acmicpc.net/problem/1113
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1113 {
	public static int N, M, answer, maxHeight, arr[][];
	public static Queue<int[]> q;
	public static boolean vtd[][];
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		answer = 0;
		maxHeight = -987654321;
		arr = new int[N][M];
		vtd = new boolean[N][M];
		q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
				if(arr[i][j] > maxHeight) maxHeight = arr[i][j];
			}
		}

		
		
		
		System.out.println(answer);
	}
}
