import java.util.Scanner;

public class Main9782 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = 1;
        while(true) {
            int n = sc.nextInt();
            if(n == 0) break;
            int sum = 0;
            for(int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if(n % 2 == 0 && (i == n/2 || i == n/2-1)) {
                    sum += val;
                } else if(n % 2 == 1 && i == n/2) {
                    sum += val;
                }
            }
            System.out.print("Case " + idx++ + ": ");
            if(n % 2 == 0) System.out.println((double)sum / 2.0);
            else System.out.println((double)sum);
        }
    }
}
