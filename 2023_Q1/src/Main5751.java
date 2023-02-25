import java.util.Scanner;

public class Main5751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if(n == 0) break;
            int m = 0;
            int j = 0;
            for(int i = 0; i < n; i++) {
                if(sc.nextInt() == 0) m++;
                else j++;
            }
            System.out.println("Mary won " + m + " times and John won " + j +" times");
        }
    }
}
