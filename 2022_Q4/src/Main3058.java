import java.util.Scanner;

public class Main3058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int answer = 0;
            int min = 987654321;
            for(int j = 0; j < 7; j++) {
                int value = sc.nextInt();
                if(value % 2 == 0) {
                    answer += value;
                    min = Math.min(min, value);
                }
            }
            System.out.println(answer + " " + min);
        }
    }
}
