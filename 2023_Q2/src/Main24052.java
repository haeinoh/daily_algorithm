import java.util.Arrays;
import java.util.Scanner;

public class Main24052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int count = 0;
        loop:for(int i = 0; i < n; i++) {
            int num =  arr[i];
            int idx = 0;
            for(int j = i; j > 0; j--) {
                System.out.println("start "  +num + " " + arr[j]);
                if(arr[j-1] > num) {
                    System.out.println(arr[j-1] + " " + arr[j]);
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    System.out.println("before "  + Arrays.toString(arr));
                    count++;
                    if(count == k) break loop;
                }
                System.out.println("count " + count);
            }
            arr[idx] = num;
            if(count == k) break loop;
            System.out.println("after "  + Arrays.toString(arr));
        }

        if(count < k) System.out.println("-1");
        else {
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
