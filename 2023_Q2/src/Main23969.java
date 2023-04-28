import java.util.Scanner;

public class Main23969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int count = 0;
        loop:for(int i = n-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    count++;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
                if(count == k) {
                    break loop;
                }
            }
        }

        if(count < k) {
            System.out.println("-1");
        } else {
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
