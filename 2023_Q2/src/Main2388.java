import java.util.Scanner;

public class Main2388 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int count = 0;

        for(int i = n-1; i > 0; i--) {
            int maxVal = 0;
            int maxIndex = 0;
            for(int j = 0; j <= i; j++) {
                if(maxVal < arr[j]) {
                    maxVal = arr[j];
                    maxIndex = j;
                }
            }
            if(maxIndex != i) {
                count++;
                int tmp = arr[i];
                arr[i] = maxVal;
                arr[maxIndex] = tmp;
                if(count == k) break;
            }
        }

        if(count < k) System.out.println("-1");
        else {
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }

    }
}
