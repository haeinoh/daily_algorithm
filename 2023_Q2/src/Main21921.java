import java.util.Scanner;

public class Main21921 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        int sum = 0;
        int[] arr = new int[x];
        for(int i = 0; i < x; i++) {
            arr[i] = sc.nextInt();
            if(i < n) sum += arr[i];
        }
        int max = sum;

        int count = 1;
        int idx = 0;
        for(int i = n; i < x; i++) {
            sum += arr[i];
            sum -= arr[idx++];

            if(sum > max) {
                max = sum;
                count = 0;
            }
            if(sum == max) {
                count++;
            }
        }

        if(sum == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
