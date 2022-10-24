import java.util.Scanner;

public class Main10102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        str = str.replaceAll("A", "");
        if(str.length() < (n - str.length())) System.out.println("A");
        else if(str.length() >  (n - str.length())) System.out.println("B");
        else System.out.println("Tie");
    }
}
