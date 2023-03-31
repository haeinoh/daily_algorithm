import java.util.Scanner;

public class Main4635 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int test = sc.nextInt();
            if(test == -1) break;

            int speed = sc.nextInt();
            int time = sc.nextInt();
            int prev = 0;
            int sum = 0;
            for(int i = 1; i <= test; i++) {
                sum += (speed*(time - prev));
                prev = time;
                if(i == test) break;
                speed = sc.nextInt();
                time = sc.nextInt();
            }
            System.out.println(sum + " miles");
        }
    }
}
