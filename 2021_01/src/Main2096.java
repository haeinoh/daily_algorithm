//https://www.acmicpc.net/problem/2096
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2096 {
	public static int N, min[], max[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		min = new int[3];
		max = new int[3];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 3; i++) {
			min[i] = Integer.parseInt(st.nextToken());
			max[i] = min[i];
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int tmp1 = max[0];
			int tmp2 = max[1];
			int tmp3 = max[2];

			max[0] = Math.max(max[0], max[1]) + a;
			max[1] = Math.max(tmp1, Math.max(max[1], max[2])) + b;
			max[2] = Math.max(tmp2, tmp3) + c;

			tmp1 = min[0];
			tmp2 = min[1];
			tmp3 = min[2];

			min[0] = Math.min(min[0], min[1]) + a;
			min[1] = Math.min(tmp1, Math.min(min[1], min[2])) + b;
			min[2] = Math.min(tmp2, tmp3) + c;
		}
		Arrays.sort(max);
		Arrays.sort(min);
		System.out.println(max[2] + " " + min[0]);
	}
}
