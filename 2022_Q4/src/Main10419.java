import java.util.Scanner;

public class Main10419 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            int value = sc.nextInt();
            int tmp = (int) Math.sqrt(value);
            int answer = 0;
            for(int j = tmp; j >= 0; j--) {
                if(value - (j + j*j) >= 0) {
                    answer = j;
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
