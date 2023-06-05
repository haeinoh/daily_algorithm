import java.util.Scanner;

public class Main6763 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a >= b) System.out.println("Congratulations, you are within the speed limit!");
        else if(b-a >= 1 && b-a <= 20) System.out.println("You are speeding and your fine is $100.");
        else if(b-a >= 21 && b-a <= 30) System.out.println("You are speeding and your fine is $270.");
        else System.out.println("You are speeding and your fine is $500.");
    }
}
