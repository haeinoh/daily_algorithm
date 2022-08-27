import java.util.Scanner;

public class Main15781 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int max = 0;
        int max2 = 0;
        for(int i = 0; i < N; i++) max = Math.max(max, sc.nextInt());
        for(int j = 0; j < M; j++) max2 = Math.max(max2, sc.nextInt());
        System.out.println(max + max2);
    }
}
