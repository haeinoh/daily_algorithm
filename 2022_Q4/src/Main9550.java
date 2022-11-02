import java.util.Scanner;

public class Main9550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int answer = 0;
            for(int j = 0; j < n; j++) {
                answer += (sc.nextInt() / k);
            }
            System.out.println(answer);
        }
    }
}
