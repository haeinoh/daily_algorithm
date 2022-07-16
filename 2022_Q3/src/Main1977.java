import java.util.Scanner;

public class Main1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int mm = (int) Math.ceil(Math.sqrt(m));
        int nn = (int) Math.sqrt(n);
        int sum = 0;
        int min = (int) Math.pow(mm, 2);
        for(int i = mm; i <= nn; i++) {
            sum += i*i;
        }
        if(sum == 0) System.out.println("-1");
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
