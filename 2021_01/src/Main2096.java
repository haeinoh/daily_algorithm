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
		min = new int[3]; // 최소값을 저장할 배열
		max = new int[3]; // 최대값을 저장할 배열 

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 3; i++) { // 맨 첫째줄로, max와 min 배열에 값을 먼저 세팅해놓는다.
			min[i] = Integer.parseInt(st.nextToken());
			max[i] = min[i];
		}

		for (int i = 1; i < N; i++) { // 두번째 줄부터 시작한다.
			st = new StringTokenizer(bf.readLine()); // 값이 3개밖에 안되므로, 그냥 변수로 입력 받는다.
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int tmp1 = max[0];
			int tmp2 = max[1];
			int tmp3 = max[2]; // 밑에 계산에서 값이 변하므로 미리 값을 tmp에 저장해놓는다.

			max[0] = Math.max(max[0], max[1]) + a; // 첫번째 -> 첫번째와 두번째
			max[1] = Math.max(tmp1, Math.max(max[1], max[2])) + b; //두번째 -> 첫번째와 두번째와 세번째
			max[2] = Math.max(tmp2, tmp3) + c; // 세번째 -> 두번째와 세번째
			//min도 max와 같은 방법으로 계산한다.
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
