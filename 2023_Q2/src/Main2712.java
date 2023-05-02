import java.util.Scanner;

public class Main2712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            double a = sc.nextDouble();
            String str = sc.next();
            switch (str) {
                case "kg":
                    a *= 2.2046;
                    str = "lb";
                    break;
                case "lb":
                    a *= 0.4536;
                    str = "kg";
                    break;
                case "l":
                    a *= 0.2642;
                    str = "g";
                    break;
                case "g":
                    a *= 3.7854;
                    str = "l";
                    break;
            }

            System.out.println(String.format("%.4f", a) + " " + str);
        }
    }
}
