import java.util.Scanner;

public class Main23812 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();


        for(int k = 0; k < 3; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) sb.append("@");
                for(int j = 0; j < n*3; j++) sb.append(" ");
                for(int j = 0; j < n; j++) sb.append("@");
                sb.append("\n");
            }
            if(k < 2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n * 5; j++) sb.append("@");
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
