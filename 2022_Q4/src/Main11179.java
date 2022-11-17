import java.util.Scanner;

public class Main11179 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(N)).reverse();
        System.out.println(Integer.parseInt(sb.toString(), 2));
    }
}
