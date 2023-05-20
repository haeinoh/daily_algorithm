import java.util.Scanner;

public class Main21866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int sum = 0;
        for(int i = 1; i <= 9; i++) {
            int val = sc.nextInt();
            sum += val;
            int tmp = (i/2 + (i%2))*100;
            if(val > tmp) flag = true;
        }

        if(flag) System.out.println("hacker");
        else if(sum >= 100) System.out.println("draw");
        else System.out.println("none");

    }
}
