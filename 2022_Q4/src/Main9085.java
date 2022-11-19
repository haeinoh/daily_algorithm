import java.util.Scanner;

public class Main9085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            int value = sc.nextInt();
            int sum = 0;
            for(int j = 0; j < value; j++) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}
