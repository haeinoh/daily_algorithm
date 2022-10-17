import java.util.Scanner;

public class Main14624 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        if(N % 2 == 0) sb.append("I LOVE CBNU");
        else {
            for(int i = 0; i < N; i++) sb.append("*");
            sb.append("\n");
            for(int i = N/2; i >= 0; i--) {
                for(int j = 0; j < i; j++) sb.append(" ");
                sb.append("*");
                if(i != N/2) {
                    for(int j = 0; j < N-2*i-2; j++) sb.append(" ");
                    sb.append("*");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
