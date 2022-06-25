import java.util.Scanner;

public class Main23037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int answer = 0;
        for(int i = 0; i < str.length(); i++) {
            answer += Math.pow((str.charAt(i)-'0'), 5);
        }
        System.out.println(answer);
    }
}
