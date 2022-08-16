import java.util.Scanner;

public class Main11170 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int answer = 0;
            for(int j = N; j <= M; j++) answer += String.valueOf(j).length() - String.valueOf(j).replace("0", "").length();
            System.out.println(answer);
        }
    }
}
