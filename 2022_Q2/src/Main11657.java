import java.util.Arrays;
import java.util.Scanner;

public class Main11657 {
    public static int N, M;
    public static int[][] arr;
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1][N+1];

        for(int[] i: arr) Arrays.fill(i, INF);

        for(int i = 0; i < M; i++) {
            arr[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(arr[i][j] != INF) {
                    dist[j] = Math.min(dist[j], dist[i]+arr[i][j]);
                }
            }
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();

//        System.out.println(Arrays.toString(dist));
        for(int i = 2; i <= N; i++) {
            if(dist[i] == 0) {
                flag = true;
                break;
            } else if(dist[i] == INF) {
                sb.append("-1");
            } else sb.append(dist[i]);
            sb.append("\n");
        }

        if(flag) System.out.println("-1");
        else System.out.println(sb.toString());
    }
}
