import java.util.Scanner;

public class Main10833 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            answer += (b % a);
        }
        System.out.println(answer);
    }
}
