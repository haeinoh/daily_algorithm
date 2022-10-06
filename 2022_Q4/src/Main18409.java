import java.util.Scanner;

public class Main18409 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
            || str.charAt(i) == 'e' || str.charAt(i) == 'u') answer++;
        }
        System.out.println(answer);
    }
}
