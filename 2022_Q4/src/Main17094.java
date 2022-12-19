import java.util.Scanner;

public class Main17094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next().replaceAll("2", "");
        if(n-str.length() > str.length()) System.out.println("2");
        else if(n-str.length() < str.length()) System.out.println("e");
        else System.out.println("yee");
    }
}
