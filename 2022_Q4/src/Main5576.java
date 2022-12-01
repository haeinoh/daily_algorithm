import java.util.Arrays;
import java.util.Scanner;

public class Main5576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        int[] b = new int[10];

        for(int i = 0; i < 10; i++) a[i] = sc.nextInt();
        for(int i = 0; i < 10; i++) b[i] = sc.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);

        System.out.print(a[9] + a[8] + a[7]);
        System.out.println(" " + (b[9] + b[8] + b[7]));
    }
}
