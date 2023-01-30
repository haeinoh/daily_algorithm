import java.util.Scanner;

public class Main5426 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int ts = 1; ts <= n; ts++) {
            String str = sc.next();
            int len = (int) Math.sqrt(str.length());
            char[][] arr = new char[len][len];

            int idx = 0;
            for(int i = 0; i < len; i++) {
                for(int j = 0; j < len; j++) {
                    arr[i][j] = str.charAt(idx++);
                }
            }

            for(int i = len-1; i >= 0; i--) {
                for(int j = 0; j < len; j++) {
                    sb.append(arr[j][i]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
