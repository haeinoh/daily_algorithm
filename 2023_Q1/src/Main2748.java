import java.util.Scanner;

public class Main2748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long prev = 1;
        long prevprev = 1;
        long sum = 0;
        if(n <= 2) System.out.println("1");
        else {
            for(int i = 3; i <= n; i++) {
                sum = prev + prevprev;
                prevprev = prev;
                prev = sum;
            }
            System.out.println(sum);
        }
    }
}
