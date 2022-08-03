import java.util.Arrays;
import java.util.Scanner;

public class Main9076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int[] arr = new int[5];
            int sum = 0;
            for(int j = 0; j < 5; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            Arrays.sort(arr);
            if(arr[3] - arr[1] >= 4) System.out.println("KIN");
            else System.out.println(sum - arr[4] - arr[0]);
        }
    }
}
