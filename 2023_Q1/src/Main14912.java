import java.util.Scanner;

public class Main14912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += String.valueOf(i).chars().filter(c -> c == (char)(d + '0')).count();
        }
        System.out.println(sum);
    }
}
