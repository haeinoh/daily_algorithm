import java.util.Scanner;

public class Main5391 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double[] arr = new double[5];
        arr[0] = 350.34;
        arr[1] = 230.90;
        arr[2] = 190.55;
        arr[3] = 125.30;
        arr[4] = 180.90;

        for(int i = 0; i < n; i++) {
            double sum = 0.0;
            for(int j = 0; j < arr.length; j++) sum += arr[j]*sc.nextInt();
            System.out.println("$" + String.format("%.2f",sum));
        }
    }
}
