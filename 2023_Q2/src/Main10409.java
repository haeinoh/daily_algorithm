import java.util.Scanner;

public class Main10409 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int sum = 0;
        int count = 0;
        boolean flag = false;
        for(int i = 1; i <= n; i++) {
            int tmp = sc.nextInt();
            if(tmp + sum > s && !flag) {
                flag = true;
            } else if(!flag) {
                count = i;
                sum += tmp;
            }
        }
        System.out.println(count);
    }
}
