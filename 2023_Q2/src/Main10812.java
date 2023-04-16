import java.util.Scanner;

public class Main10812 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++) arr[i] = i;

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int[] tmp = new int[b-a+1];
            int idx = 0;
            for(int j = c; j <= b; j++) tmp[idx++] = arr[j];
            for(int j = a; j < c; j++) tmp[idx++] = arr[j];
            idx = 0;
            for(int j = a; j <= b; j++) arr[j] = tmp[idx++];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb.toString());
    }
}
