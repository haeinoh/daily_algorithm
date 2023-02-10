import java.util.Scanner;

public class Main21591 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wc = sc.nextInt();
        int hc = sc.nextInt();
        int ws = sc.nextInt();
        int hs = sc.nextInt();

        if(wc - ws >= 2 && hc - hs >= 2) System.out.println("1");
        else System.out.println("0");
    }
}
