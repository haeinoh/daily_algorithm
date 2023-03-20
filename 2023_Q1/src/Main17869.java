import java.util.Scanner;

public class Main17869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int num = 0;
        while(a > 1) {
            if(a % 2 == 0) a /= 2;
            else a+=1;
            num++;
        }
        System.out.println(num);
    }
}
