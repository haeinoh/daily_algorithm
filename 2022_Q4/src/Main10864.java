import java.util.Scanner;

public class Main10864 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a]++;
            arr[b]++;
        }

        for(int i = 1; i <= n; i++) {
            System.out.println(arr[i]);
        }
    }
}
