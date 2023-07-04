import java.util.Scanner;

public class Main5341 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if(n == 0) break;
            System.out.println(n*(n+1)/2);
        }
    }
}
