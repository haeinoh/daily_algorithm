import java.util.Scanner;

public class Main11575 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int ts = 1; ts <= T; ts++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String str = sc.next();

            for(int i = 0; i < str.length(); i++) {
                int val = (a * (str.charAt(i) - '0' - 17) + b) % 26;
                sb.append((char)(val + '0' + 17));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
