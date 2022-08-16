import java.util.Scanner;

public class Main10179 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            double value = sc.nextDouble();
            sb.append("$").append(String.format("%.2f", (value*0.8))).append("\n");
        }
        System.out.println(sb.toString());
    }
}
