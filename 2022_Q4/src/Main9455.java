import java.util.Scanner;

public class Main9455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[m][n];

            int answer = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = m-1; j >= 0; j--) {
                    if(arr[j][i] == 1) {
                        for(int k = m-1; k > j; k--) {
                            if(arr[k][i] == 0) {
                                answer += (k-j);
                                arr[j][i] = 0;
                                arr[k][i] = 1;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
