import java.util.Scanner;

public class Main15813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        int answer = 0;
        for(int i = 0; i < str.length(); i++) answer += (str.charAt(i) - 64);
        System.out.println(answer);
    }
}
