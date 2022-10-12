import java.util.Scanner;

public class Main5354 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int value = sc.nextInt();
            if(value == 1) sb.append("#");
            else {
                for(int j = 0; j < value; j++) sb.append("#");
                sb.append("\n");
                for(int j = 0; j < value - 2; j++) {
                    sb.append("#");
                    for(int k = 0; k < value - 2; k++) sb.append("J");
                    sb.append("#");
                    sb.append("\n");
                }
                for(int j = 0; j < value; j++) sb.append("#");
            }
            if(i != N-1) {
                sb.append("\n");
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
