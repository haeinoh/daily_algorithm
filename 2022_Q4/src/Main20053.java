import java.util.Scanner;

public class Main20053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int min = 987654321;
            int max = -1000000;
            for(int j = 0; j < N; j++) {
                int value = sc.nextInt();
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
            System.out.println(min + " " + max);
        }
    }
}
