import java.util.Arrays;
import java.util.Scanner;

// selection sort (1)
public class Main23881 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int num1 = 0;
        int num2 = 0;

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int time = 0;
        for(int i = arr.length - 1; i > 0; i--) {
            int maxIndex = 0;
            int max = 0;
            for(int j = 0; j <= i; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }

            if(maxIndex != i) {
                time++;
                if(time == k) {
                    num1 = arr[i];
                    num2 = max;
                    break;
                }
                int tmpVal = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = tmpVal;
            }

        }

        if(num1 != 0 && num2 != 0) System.out.println(num1 + " " + num2);
        else System.out.println("-1");
    }
}
