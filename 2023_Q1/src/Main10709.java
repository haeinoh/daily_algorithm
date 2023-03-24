import java.util.Scanner;

public class Main10709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String str = sc.next();
            for(int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                if(ch == 'c') arr[i][j] = 0;
                else arr[i][j] = -1;
            }

            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                    for(int k = j+1; k < m; k++) {
                        if(arr[i][k] != 0) {
                            arr[i][k] = 1 + arr[i][k-1];
                        } else break;
                    }
                }
            }

            for(int j = 0; j < m; j++) sb.append(arr[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
