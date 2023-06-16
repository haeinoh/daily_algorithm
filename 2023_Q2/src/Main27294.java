import java.util.Scanner;

public class Main27294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int s = sc.nextInt();

        if(t > 16 || t <= 11 || s == 1) System.out.println("280");
        else  System.out.println("320");
    }
}
