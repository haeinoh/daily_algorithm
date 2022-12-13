import java.util.Scanner;

public class Main24568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt()*8 + sc.nextInt()*3;

        System.out.println((val - 28 > 0) ? (val-28) : 0);
    }
}
