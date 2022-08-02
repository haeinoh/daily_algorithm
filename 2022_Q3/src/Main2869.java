import java.util.Scanner;

public class Main2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        int tmp = V - A;
        int ans = 1;
        ans += Math.ceil(tmp/(double)(A-B));
        System.out.println(ans);
    }
}
