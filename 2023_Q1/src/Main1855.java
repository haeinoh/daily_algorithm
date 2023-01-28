import java.util.Scanner;

public class Main1855 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[][] arr = new char[str.length()/n][n];

        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(idx++);
                }
            } else {
                for(int j = n-1; j >= 0; j--) {
                    arr[i][j] = str.charAt(idx++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < arr.length; i++) {
                sb.append(arr[i][j]);
            }
        }

        System.out.println(sb.toString());
    }
}
