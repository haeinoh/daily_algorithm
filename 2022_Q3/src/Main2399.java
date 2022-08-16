import java.util.Scanner;

public class Main2399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = sc.nextInt();

        long answer = 0L;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                answer += Math.abs(arr[i] - arr[j]);
            }
        }
        System.out.println(answer);
    }
}
