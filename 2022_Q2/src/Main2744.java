import java.util.Scanner;

public class Main2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') sb.append(String.valueOf(str.charAt(i)).toLowerCase());
            else sb.append(String.valueOf(str.charAt(i)).toUpperCase());
        }
        System.out.println(sb.toString());
    }
}
