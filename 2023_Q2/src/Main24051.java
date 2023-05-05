import java.util.Arrays;
import java.util.Scanner;

public class Main24051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int count = 0;
        int num = 0;
        for(int i = 1; i < n; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(arr[j] > arr[j+1]) {
                    num = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = num;;
                    count++;
                }
                if(count == k) break;
                System.out.println(num + " " + count+ " " + Arrays.toString(arr));
            }
        }
        if(count == k) System.out.println(num);
        else System.out.println("-1");
    }
}
