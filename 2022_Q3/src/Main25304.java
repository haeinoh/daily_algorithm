import java.util.Scanner;

public class Main25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            X -= (sc.nextInt()*sc.nextInt());
        }
        if(X == 0) System.out.println("Yes");
        else System.out.println("No");
    }
}
