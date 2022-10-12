import java.util.Scanner;

public class Main17863 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(str.substring(0, 3).equals("555")) System.out.println("YES");
        else System.out.println("NO");
    }
}
