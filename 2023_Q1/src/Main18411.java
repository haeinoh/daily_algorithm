import java.util.Scanner;

public class Main18411 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int min = 987654321;

        for(int i = 0; i < 3; i++) {
            int num = sc.nextInt();
            min = Math.min(min, num);
            sum += num;
        }
        System.out.println(sum-min);
    }
}
