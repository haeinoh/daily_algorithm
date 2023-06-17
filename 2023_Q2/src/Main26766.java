import java.util.Scanner;

public class Main26766 {
    public static void print() {
        StringBuilder  sb = new StringBuilder();
        sb.append(" @@@   @@@ \n");
        sb.append("@   @ @   @\n");
        sb.append("@    @    @\n");
        sb.append("@         @\n");
        sb.append(" @       @ \n");
        sb.append("  @     @  \n");
        sb.append("   @   @   \n");
        sb.append("    @ @    \n");
        sb.append("     @     \n");
        System.out.print(sb.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            print();
        }
    }
}
