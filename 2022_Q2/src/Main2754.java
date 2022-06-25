import java.util.Scanner;

public class Main2754 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        double num = 0.0;
        switch (str.charAt(0)) {
            case 'A':
                num = 4.3;
                break;
            case 'B':
                num = 3.3;
                break;
            case 'C':
                num = 2.3;
                break;
            case 'D':
                num = 1.3;
                break;
        }

        if(str.charAt(0) != 'F') {
            switch (str.charAt(1)) {
                case '0':
                    num -= 0.3;
                    break;
                case '-':
                    num -= 0.6;
                    break;
            }
        }
        System.out.println(String.format("%.1f",num));
    }
}
