import java.util.Scanner;

public class Main23795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(true) {
            int val = sc.nextInt();
            if(val == -1) break;
            sum += val;
        }
        System.out.println(sum);
    }
}
