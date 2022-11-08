import java.util.Scanner;

public class Main2010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        for(int i = 0; i < N; i++) {
            answer += sc.nextInt();
        }
        System.out.println(answer - N + 1);
    }
}
