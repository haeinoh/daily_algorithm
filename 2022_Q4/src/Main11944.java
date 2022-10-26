import java.util.Scanner;

public class Main11944 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a; i++) {
            if(sb.length() > b) {
                sb = new StringBuilder(sb.substring(0, b));
                break;
            }
            sb.append(a);
        }
        System.out.println(sb.toString());
    }
}
