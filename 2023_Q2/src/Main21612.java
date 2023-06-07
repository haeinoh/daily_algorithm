import java.util.Scanner;

public class Main21612 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tmp = 5*sc.nextInt()-400;
        System.out.println(tmp);
        if(tmp < 100) System.out.println("1");
        else if(tmp == 100) System.out.println("0");
        else System.out.println("-1");
    }
}