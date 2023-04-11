import java.util.Scanner;

public class Main10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n+1];
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();

            for(int j = a; j <= b; j++) arr[j] = k;
        }

        for(int i = 1; i < arr.length; i++) System.out.print(arr[i] + " ");
    }
}
