import java.util.Scanner;

public class Main6502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 1;
        while(sc.hasNext()) {
            int a = sc.nextInt();
            if(a == 0) break;
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(2*a*2*a >= (b*b + c*c)) System.out.println("Pizza " + index + " fits on the table.");
            else System.out.println("Pizza " + index + " does not fit on the table.");
            index++;
        }
    }
}
