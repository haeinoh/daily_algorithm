//https://www.acmicpc.net/problem/1697

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1697 {
	public static int N, K, answer;
	public static int dx[] = { -1, 1, 2 };
	public static Queue<int[]> q;
	public static boolean vtd[];

	public static void solve() {
		loop: while (!q.isEmpty()) {
			int tmp[] = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i = 0; i < dx.length; i++) {
				int nx = 0;
				int ny = 0;
				if (i != 2)
					nx = x + dx[i];
				else
					nx = x * dx[2];

				ny += (y + 1);

				if (nx < 0 || nx > 100000 || ny > answer)
					continue;
				if (nx == K) {
					answer = ny;
					break loop;

				} else if (!vtd[nx] && ny < answer) {
					q.add(new int[] { nx, ny });
				}
				vtd[nx] = true;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		vtd = new boolean[100001];
		q = new LinkedList<>();

		q.add(new int[] { N, 0 });
		vtd[N] = true;
		answer = 987654321;
		if (N == K)
			answer = 0;
		else
			solve();
		System.out.println(answer);
	}
}