import java.util.Scanner;

public class Main22966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String answer = "";
        int value = 987654321;

        for(int i = 0; i < N; i++) {
            String str = sc.next();
            int var = sc.nextInt();
            if(value > var) {
                value = var;
                answer = str;
            }
        }
        System.out.println(answer);
    }
}
