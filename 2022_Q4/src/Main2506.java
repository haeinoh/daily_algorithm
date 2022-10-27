import java.util.Scanner;

public class Main2506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int prev = 1;

        for(int i = 1; i <= n; i++) {
            int value = sc.nextInt();

            if(value == 1) answer+=prev++;
            else prev = 1;
        }

        System.out.println(answer);
    }
}
