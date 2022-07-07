import java.util.Scanner;

public class Main2522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < N - 1; j++) {
            for (int k = 0; k < N - j - 1; k++) sb.append(" ");
            for (int k = 0; k < j + 1; k++) sb.append("*");
            sb.append("\n");
        }
        for (int j = 0; j < N; j++) sb.append("*");
        sb.append("\n");
        for (int j = 0; j < N - 1; j++) {
            for (int k = 0; k < j+1; k++) sb.append(" ");
            for (int k = 0; k < N-j-1; k++) sb.append("*");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
