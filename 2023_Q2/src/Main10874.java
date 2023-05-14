import java.util.Scanner;

public class Main10874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= 10; j++) {
                if(((j-1) % 5) + 1 == sc.nextInt()) count++;
            }
            if(count == 10) System.out.println(i);
        }
    }
}
