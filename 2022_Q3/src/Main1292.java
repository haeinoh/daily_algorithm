import java.util.Scanner;

public class Main1292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int[] arr = new int[B+1];

        int cnt = 0;
        int num = 1;
        int sum = 0;
        for(int i = 1; i <= B; i++) {
            if(i >= A && i <= B) sum += num;
            cnt++;
            if(cnt == num) {
                cnt = 0;
                num++;
            }
        }
        System.out.println(sum);
    }
}
