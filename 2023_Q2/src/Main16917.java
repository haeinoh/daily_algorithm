import java.util.Scanner;

public class Main16917 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int min = a*x + b*y;
        int gap = Math.min(x, y);
        min = Math.min(min, c*gap*2 + Math.abs(x-gap)*a + Math.abs(y-gap)*b);
        min = Math.min(min, c*Math.max(x,y)*2);

        System.out.println(min);
    }
}
