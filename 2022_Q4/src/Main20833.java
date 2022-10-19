import java.util.Scanner;

public class Main20833 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int value = 0;

        for(int i = 1; i <= N; i++) {
            value += Math.pow(i, 3);
        }
        System.out.println(value);
    }
}
