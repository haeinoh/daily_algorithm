import java.util.Scanner;

public class Main10093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        if(A > B) {
            long tmp = A;
            A = B;
            B = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(long i = A+1; i < B; i++) {
            sb.append(i).append(" ");
        }
        if(A == B) System.out.println("0");
        else System.out.println(B-A-1);
        System.out.println(sb.toString());
    }
}
