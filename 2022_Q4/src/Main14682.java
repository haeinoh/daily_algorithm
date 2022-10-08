import java.util.Scanner;

public class Main14682 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int K = sc.nextInt();
        int answer = 0;
        for(int i = 0; i <= K; i++) {
            answer += Integer.parseInt(str);
            str = str + "0";
        }
        System.out.println(answer);
    }
}
