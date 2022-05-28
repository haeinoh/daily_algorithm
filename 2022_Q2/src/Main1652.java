import java.util.Arrays;
import java.util.Scanner;

public class Main1652 {
    public static int N;
    public static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];

        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int row = 0;
        int col = 0;
        for(int i = 0; i < N; i++) {
            // 가로
            int cntR = 0;
            int cntC = 0;
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 'X') {
                    if(cntR >= 2) row++;
                    cntR = 0;
                } else cntR++;
                if(arr[j][i] == 'X') {
                    if(cntC >= 2) col++;
                    cntC = 0;
                } else cntC++;
            }
            if(cntR >= 2) row++;
            if(cntC >= 2) col++;
        }
        System.out.println(row);
        System.out.println(col);
    }
}
