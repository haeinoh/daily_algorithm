import java.util.Scanner;

public class Main18414 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int min = 987654321;
        int answer = 0;
        for(int i = l; i <= r; i++) {
           if(min >= Math.abs(x - i)) {
               min = Math.abs(x - i);
               answer = i;
           }
        }
        System.out.println(answer);
    }
}
