import java.util.Arrays;
import java.util.Scanner;

public class Main2863 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        double[] arr = new double[4];
        arr[0] = (a/(double)c) + (b/(double)d);
        arr[1] = (c/(double)d) + (a/(double)b);
        arr[2] = (d/(double)b) + (c/(double)a);
        arr[3] = (b/(double)a) + (d/(double)c);

        double max = arr[0];
        int index = 0;
        for(int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}
