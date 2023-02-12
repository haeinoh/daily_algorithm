import java.util.Scanner;

public class Main5218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            sb.append("Distance: ");
            for(int j = 0; j < a.length(); j++) {
                int x = a.charAt(j) - '0' - 49;
                int y = b.charAt(j) - '0' - 49;

                if(x <= y) sb.append(y-x);
                else sb.append((y+26)-x);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
