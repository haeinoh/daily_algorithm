import java.util.Arrays;
import java.util.Scanner;

public class Main2799 {
    public static char[][] arr;
    public static int solve(int x, int y) {
        int count = 0;
        for(int i = x; i < x+4; i++) if(arr[i][y] == '*') count++;
        return count;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        arr = new char[a*4+2+(a-1)][b*4+2+(b-1)];

        for(int i = 0; i < arr.length; i++) {
            String str = sc.next();
            for(int j = 0; j < arr[0].length; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int[] answer = new int[5];
        int x = 1;
        int y = 1;
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                answer[solve((i*5+1), (j*5+1))]++;
            }
        }

        for(int i = 0; i < 5; i++) System.out.print(answer[i] + " ");
    }
}
