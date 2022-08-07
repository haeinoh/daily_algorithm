import java.util.Scanner;

public class Main2845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        num *= sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 5; i++) {
            sb.append(sc.nextInt() - num).append(" ");
        }
        System.out.println(sb.toString());
    }
}
