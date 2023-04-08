import java.util.Arrays;
import java.util.Scanner;

public class Main10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = i+1;

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            int[] tmp = Arrays.copyOfRange(arr, a, b+1);
            int idx = 0;
            for(int j = b; j >= a; j--) arr[j] = tmp[idx++];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append(arr[i]).append(" ");

        System.out.println(sb.toString());
    }
}
