import java.util.Scanner;

public class Main1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int answer = 0;
        for(int i = 666; ; i++) {
            if(String.valueOf(i).contains("666")) cnt++;
            if(cnt == n) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
