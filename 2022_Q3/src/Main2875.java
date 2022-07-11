import java.util.Scanner;

public class Main2875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        while(k > 0) {
            if(n/2 >= m) n--;
            else m--;
            k--;
        }
        System.out.println(Math.min(n/2,m));
    }
}
