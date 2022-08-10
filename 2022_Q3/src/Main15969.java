import java.util.Scanner;

public class Main15969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int min = 987654321;
        int max = 0;

        for(int i = 0; i < N; i++) {
            int value = sc.nextInt();
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        System.out.println(max - min);
    }
}
