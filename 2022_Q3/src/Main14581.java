import java.util.Scanner;

public class Main14581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        sb.append(":fan::fan::fan:\n");
        sb.append(":fan::").append(str).append("::fan:\n");
        sb.append(":fan::fan::fan:\n");
        System.out.println(sb.toString());
    }
}
