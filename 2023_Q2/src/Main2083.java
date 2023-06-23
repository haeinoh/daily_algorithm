import java.util.Scanner;

public class Main2083 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        while(true) {
            String name = sc.next();
            int age = sc.nextInt();
            int height = sc.nextInt();
            if(name.equals("#")) break;
            sb.append(name);
            if(age > 17 || height >= 80) sb.append(" Senior\n");
            else sb.append(" Junior\n");
        }
        System.out.println(sb.toString());
    }
}
