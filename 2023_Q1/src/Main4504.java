import java.util.Scanner;

public class Main4504{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while(true) {
            int val = sc.nextInt();
            if(val == 0) break;

            sb.append(val).append(" ");
            if(val % n != 0) sb.append("is NOT a multiple of ").append(n).append(".");
            else sb.append("is a multiple of ").append(n).append(".");

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
