import java.util.Scanner;

public class Main25704 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int price = sc.nextInt();
        int min = 987654321;

        if(n >= 20) min = Math.min(min, (int) (price *0.75));
        if(n >= 15) min = Math.min(min, price-2000);
        if(n >= 10) min = Math.min(min, (int)(price*0.9));
        if(n >= 5) min = Math.min(min, (price - 500));

        if(min < 0) System.out.println("0");
        else if(min == 987654321) System.out.println(price);
        else System.out.println(min);
    }
}
