import java.util.Scanner;

public class Main25206 {
    public static double solve(String str) {
        switch (str) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "F":
                return 0.0;
        }
        return 0.0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0.0;
        double sumOfGrade = 0.0;
        for(int i = 0; i < 20; i++) {
            String str = sc.next();
            double unit = sc.nextDouble();
            String tmp = sc.next();
            double grade = 0.0;
            if(!tmp.equals("P")) {
                grade = solve(tmp);
                sum += unit;
                sumOfGrade += (unit*grade);
            }
        }
        System.out.println(String.format("%.6f", (sumOfGrade/sum)));
    }
}
