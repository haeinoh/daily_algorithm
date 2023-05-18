import java.util.Scanner;

public class Main4892 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = 1;
        while(true) {
            int n = sc.nextInt();
            if(n == 0) break;
            int n1 = 3*n;
            if((3*n) % 2 == 0) n = n1/2;
            else n = (n1+1)/2;
            n*=3;
            n/=9;
            System.out.print(idx++ + ". ");
            if(n1 % 2 == 0) System.out.println("even " + n);
            else System.out.println("odd " + n);
        }
    }
}
