import java.util.Scanner;

public class Main11586 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] arr = new char[n][n];

        for(int i = 0; i < n; i++) {
            String str = sc.next();
            for(int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int val = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        if(val == 1) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }

        } else if(val == 2) {
            for(int i = 0; i < n; i++) {
                for(int j = n-1; j >= 0; j--) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
        } else {
            for(int i = n-1; i >= 0; i--) {
                for(int j = 0; j < n; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
