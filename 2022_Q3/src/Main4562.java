import java.util.Scanner;

public class Main4562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a < b) System.out.println("NO BRAINS");
            else System.out.println("MMM BRAINS");
        }
    }
}
