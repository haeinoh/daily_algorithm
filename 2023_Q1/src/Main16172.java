import java.util.Scanner;

public class Main16172 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String target = sc.next();

        str = str.replaceAll("[0-9]", "");
        if(str.contains(target)) System.out.println("1");
        else System.out.println("0");
    }
}
