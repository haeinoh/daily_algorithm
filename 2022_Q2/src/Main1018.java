import java.util.Scanner;

public class Main1018 {
    public static int N, M;
    public static char[][] arr;
    public static int solve(int sx, int sy) {
       char val = arr[sx][sy];
       int count = 0;
       boolean flag = false;
       for(int i = sx; i < sx+8; i++) {
           for(int j = sy; j < sy+8; j++) {
               if(arr[i][j] != val) count++;
               val = val == 'W' ? 'B' : 'W';
           }
           val = val == 'W' ? 'B' : 'W';
       }
       return Math.min(count, (64-count));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new char[N][M];
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int cnt = 0;
        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= M-8; j++) {
                answer = Math.min(answer, solve(i, j));
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(answer);
    }
}
