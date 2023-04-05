import java.util.Scanner;

public class Main23627 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(str.length() >= 5 && str.substring(str.length() - 5).equals("driip")) System.out.println("cute");
        else System.out.println("not cute");
    }
}
