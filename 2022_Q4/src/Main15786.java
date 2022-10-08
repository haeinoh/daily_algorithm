import java.util.Scanner;

public class Main15786 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String base = sc.next();

        for(int i = 0; i < M; i++) {
            String tmp = sc.next();
            if(tmp.contains(base)) System.out.println("true");
            else System.out.println("false");
        }
    }
}
