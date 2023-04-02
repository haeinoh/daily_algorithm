import java.util.Scanner;

public class Main17283 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();
        int sum = 0;
        int idx = 2;
        while(true) {
            L = (int) (L * (R /100.0));
            if(L <= 5) break;
            sum += L*idx;
            idx*=2;
        }

        System.out.println(sum);
    }
}
