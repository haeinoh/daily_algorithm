import java.util.Arrays;
import java.util.Scanner;

public class Main1058 {
    public static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) == 'Y' ? 1 : 0;
            }
        }
        System.out.println("?");
        int answer = 0;

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = i; j < N; j++) {
                    if(i == j || i == k || j == k) continue;
                    System.out.println(k + " // " +  arr[i][j] + " "  + arr[i][k] + " " + arr[k][j]);
                    if(arr[i][j] < arr[i][k] + arr[k][j]) arr[i][j] = arr[i][k] + arr[k][j];
                }
                System.out.println();
            }
        }

        for(int[] p: arr) System.out.println(Arrays.toString(p));

        System.out.println(answer);
    }
}
