import java.util.Scanner;

public class Main28281 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        long min = 987654321L;
        for(int i = 0; i < n-1; i++) {
            min = Math.min(min,arr[i]*x + arr[i+1]*x);
        }
        System.out.println(min);
    }
}
