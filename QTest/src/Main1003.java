import java.util.Arrays;
import java.util.Scanner;

public class Main1003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int answer = 0;
        for(int i = 0; i < N; i++) arr[i] = sc.nextInt();

        int[] memo = new int[N];
        memo[0] = 1;
        for(int i = 1; i < N; i++) {
            int max = 0;
            for(int j = i; j >= 0; j--) {
                if(arr[i] > arr[j] && memo[j] > max) max = memo[j];
            }
            memo[i] = max + 1;
            answer = Math.max(answer, memo[i]);
        }

        System.out.println(answer);
    }
}
