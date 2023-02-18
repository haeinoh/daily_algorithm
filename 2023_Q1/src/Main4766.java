import java.util.Scanner;

public class Main4766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double prev = sc.nextDouble();
        while(true) {
            double value = sc.nextDouble();
            if(value == 999) break;
            System.out.println(String.format("%.2f",(value-prev)));
            prev = value;
        }
    }
}
