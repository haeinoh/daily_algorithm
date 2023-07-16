import java.util.Scanner;

public class Main23320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] >= y) cnt++;
        }
        System.out.println((int)(n*x/100) + " " + cnt);
    }
}
