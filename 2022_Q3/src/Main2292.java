import java.util.Scanner;

public class Main2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int value = 1;
        int prev = value;
        int answer = 0;
        for (int i = 0; ; i++) {
            prev = value;
            value = value + 6 * i;
            if(prev <= N && N <= value) {
                answer = (i+1);
                break;
            }
        }
        System.out.println(answer);
    }
}
