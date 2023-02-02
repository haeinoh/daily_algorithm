import java.util.Scanner;

public class Main12778 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int ts = 1; ts <= T; ts++) {
            int m = sc.nextInt();
            char val = sc.next().charAt(0);

            if(val == 'C') { // alpha -> num
                for(int i = 0; i < m; i++) {
                    sb.append(sc.next().charAt(0)-64).append(" ");
                }
            } else {
                for(int i = 0; i < m; i++) {
                    sb.append((char)(sc.nextInt()+64)).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
