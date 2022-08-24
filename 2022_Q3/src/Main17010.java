import java.util.Scanner;
public class Main17010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < L; i++) {
            int value = sc.nextInt();
            String ch = sc.next();
            for(int j = 0; j < value; j++) sb.append(ch);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
