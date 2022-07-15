import java.util.Scanner;

public class Main2576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int min = 987654321;
        for(int i = 0; i < 7; i++) {
            int num = sc.nextInt();
            if(num % 2 == 1) {
                min = Math.min(min, num);
                sum += num;
            }
        }
        if(min == 987654321) System.out.println("-1");
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
