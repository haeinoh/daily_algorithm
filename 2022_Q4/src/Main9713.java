import java.util.Scanner;

public class Main9713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prev = 0;
        for(int i = 0; i < n; i++) {
            int value = sc.nextInt();
            if(value % 2 != 0) prev += value;
            System.out.println(prev);
        }
    }
}
