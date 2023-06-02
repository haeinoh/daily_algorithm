import java.util.Scanner;

public class Main10829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long val = sc.nextLong();
        String answer = "";

        while(val >= 1) {
            answer = (val % 2) + answer;
            val /= 2;
        }
        System.out.println(answer);
    }
}
