import java.util.Scanner;

public class Main10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++) arr[i] = i;
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb.toString());
    }
}
