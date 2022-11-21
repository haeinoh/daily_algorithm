import java.util.Scanner;

public class Main17389 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        int bonus = 0;
        String str = sc.next();
        for(int i = 0; i < N; i++) {
            char ch = str.charAt(i);
            if(ch == 'X') bonus = 0;
            else {
                answer += (i+1);
                answer += bonus++;
            }
        }
        System.out.println(answer);
    }
}
