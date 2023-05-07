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
        int answer = 0;
        loop:for(int i = 0; i < n; i++) {
            int num =  arr[i];
            int idx = 0;
            for(int j = i; j > 0; j--) {
//                System.out.println("start "  +num + " " + arr[j]);
                if(arr[j-1] > num) {
//                    System.out.println(arr[j-1] + " " + arr[j]);
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
//                    System.out.println("before "  + Arrays.toString(arr));
                    count++;
                    answer = tmp;
                    if(count == k) break loop;
                } else {
                    idx = j;
                    count++;
                    break;
                }
            }
            arr[idx] = num;
//            System.out.println("after "  + Arrays.toString(arr));
        }

        if(count == k) System.out.println(answer);
        else System.out.println("-1");
    }
}
