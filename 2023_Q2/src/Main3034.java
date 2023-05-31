import java.util.Scanner;

public class Main3034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        double di = Math.sqrt(w*w + h*h);
        for(int i = 0; i < n; i++) {
            int value = sc.nextInt();
            if(value <= w || value <= h || value <= di) System.out.println("DA");
            else System.out.println("NE");
        }
    }
}
