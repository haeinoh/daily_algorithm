import java.util.Scanner;

public class Main13235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.next());
        if(str.toString().equals(str.reverse().toString())) System.out.println("true");
        else System.out.println("false");
    }
}
