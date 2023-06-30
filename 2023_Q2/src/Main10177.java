import java.util.Scanner;

public class Main10177 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[][] arr = new int[m][m];

            boolean flag = false;
            int sum = 0;
            for(int j = 0; j < m; j++) {
                int tmp = 0;
                for(int k = 0; k < m; k++) {
                    arr[j][k] = sc.nextInt();
                    if(j == 0) sum += arr[j][k];
                    tmp += arr[j][k];
                }
                if(sum != tmp) flag = true;
            }

            if(!flag) {
                for(int j = 0; j < m; j++) {
                    int tmp = 0;
                    for(int k = 0; k < m; k++) {
                        tmp += arr[k][j];
                    }

                    if(sum != tmp) {
                        flag = true;
                        break;
                    }
                }

                int val = 0;
                int val2 = 0;
                for(int j = 0; j < m; j++) {
                    val += arr[j][j];
                    val2 += arr[m-j-1][m-j-1];
                }
                if(sum != val || sum != val2) flag = true;
            }
            if(!flag) sb.append("Magic square of size " + m + "\n");
            else sb.append("Not a magic square\n");
        }
        System.out.println(sb.toString());
    }
}
