import java.util.Scanner;

public class Main15340 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == 0 && b == 0) break;
            int sum = a*30 + b*40;
            sum = Math.min(sum, (a*35+b*30));
            sum = Math.min(sum, (a*40+b*20));
            System.out.println(sum);
        }
    }
}
