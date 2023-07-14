import java.util.Scanner;

public class Main13484 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        int sum = 0;
        for(int i = 0; i < n; i++) {
            int p = sc.nextInt();
            if(p > x) sum -= (p-x);
            else sum += (x-p);
        }

        System.out.println(x+sum);
    }
}
