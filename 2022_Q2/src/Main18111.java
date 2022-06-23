import java.util.Scanner;

public class Main18111 {
    public static int N, M, B, max, min, time, height;
    public static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        B = sc.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }

        time = Integer.MAX_VALUE;
        for(int k = max; k >= min; k--) {
            int cnt = 0;
            int tTime = 0;
            int tB = B;
            for(int j = 0; j < M; j++) {
            for(int i = 0; i < N; i++) {

                    if(arr[i][j] < k) {
                        int tmp = k - arr[i][j];
                        if(tB >= tmp) {
                            tB -= tmp;
                            tTime+=tmp;
                            cnt++;
                        }
                    } else if(arr[i][j] > k) {
                        tB += arr[i][j] - k;
                        tTime += (2*(arr[i][j]-k));
                        cnt++;
                    } else cnt++;
                }
            }
            if(cnt == N*M && time > tTime) {
                time = tTime;
                height = k;
            }
        }

        System.out.println(time + " " + height);
    }
}
