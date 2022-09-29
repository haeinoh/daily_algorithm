import java.util.Scanner;

public class Main20540 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        StringBuilder sb = new StringBuilder();

        if(str.charAt(0) == 'E') sb.append("I");
        else sb.append("E");

        if(str.charAt(1) == 'S') sb.append("N");
        else sb.append("S");

        if(str.charAt(2) == 'T') sb.append("F");
        else sb.append("T");

        if(str.charAt(3) == 'J') sb.append("P");
        else sb.append("J");

        System.out.println(sb.toString());
    }
}
