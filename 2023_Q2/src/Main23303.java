import java.util.Scanner;

public class Main23303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.contains("D2") || str.contains("d2")) System.out.println("D2");
        else System.out.println("unrated");
    }
}
