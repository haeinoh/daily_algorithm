import java.util.Scanner;

public class Main14761 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            if(i % x == 0 && i % y  == 0) sb.append("FizzBuzz");
            else if(i % x == 0) sb.append("Fizz");
            else if(i % y == 0) sb.append("Buzz");
            else sb.append(i);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
