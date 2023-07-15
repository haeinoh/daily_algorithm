import java.util.Scanner;

public class Main20112 {
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

        boolean flag = false;
        for(int i = 0; i < n; i++) {
            String col = "";
            String row = "";
            for(int j = 0; j < n; j++) {
                col += arr[i][j];
                row += arr[j][i];
            }
            if(!col.equals(row)) {
                flag = true;
                break;
            }
        }
        if(flag) System.out.println("NO");
        else System.out.println("YES");
    }
}
