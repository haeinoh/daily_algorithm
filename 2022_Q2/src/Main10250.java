import java.util.Scanner;

public class Main10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int ts = 1; ts <= test; ts++){
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            if(n % h == 0) System.out.println(h*100+(n/h));
            else System.out.println((n%h)*100+(n/h)+1);
        }
    }
}
