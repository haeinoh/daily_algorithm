import java.util.Scanner;

public class Main13410 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int max = 0;
        for(int i = 1; i <= k; i++) {
            StringBuilder str = new StringBuilder(String.valueOf(n*i));
            str = str.reverse();
            max = Math.max(max, Integer.parseInt(str.toString()));
        }
        System.out.println(max);
    }
}
