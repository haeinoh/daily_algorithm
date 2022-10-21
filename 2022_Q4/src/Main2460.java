import java.util.Scanner;

public class Main2460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int ppl = 0;
        for(int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ppl -= a;
            ppl += b;
            max = Math.max(ppl, max);
        }
        System.out.println(max);
    }
}
