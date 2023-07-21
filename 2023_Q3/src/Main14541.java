import java.util.Scanner;

public class Main14541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int n = sc.nextInt();
            if(n == -1) break;

            int prev = 0;
            int sum = 0;
            for(int i = 0; i < n; i++) {
                int speed = sc.nextInt();
                int total = sc.nextInt();
                if(prev == 0) sum += speed*total;
                else sum += (speed *(total-prev));
                prev = total;
            }
            System.out.println(sum + " miles");
        }
    }
}
