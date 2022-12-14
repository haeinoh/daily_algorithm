import java.util.Scanner;

public class Main21300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        for(int i = 0; i < 6; i++) {
            answer += (sc.nextInt()*5);
        }
        System.out.println(answer);
    }
}
