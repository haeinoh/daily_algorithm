import java.util.Scanner;

public class Main3036 {
    public static int solve(int a, int b) {
        if(b == 0) return a;
        else return solve(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int first = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < N; i++) {
            int num = sc.nextInt();
            int value = solve(first, num);
            sb.append(first/value).append("/").append(num/value).append("\n");
        }
        System.out.println(sb.toString());
    }
}
