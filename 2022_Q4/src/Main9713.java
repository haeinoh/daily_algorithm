import java.util.Scanner;

public class Main9713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int sum = 0;
            for(int j = 1; j <= value; j++) if(j % 2 != 0) sum += j;
            System.out.println(sum);
        }
    }
}
