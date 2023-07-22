import java.util.Scanner;

public class Main24544 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int real = 0;
        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if(tmp == 0) real += arr[i];
        }
        System.out.println(sum);
        System.out.println(real);
    }
}
