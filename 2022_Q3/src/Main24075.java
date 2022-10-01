import java.util.Scanner;

public class Main24075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int min = 201;
        int max = -201;
        min = Math.min(min, (Math.min((a-b), (a+b))));
        max = Math.max(min, (Math.max((a-b), (a+b))));
        System.out.println(max);
        System.out.println(min);
    }
}
