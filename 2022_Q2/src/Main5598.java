import java.util.Scanner;

public class Main5598 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch <='C') sb.append((char)(ch+23));
            else sb.append((char)(ch-3));
        }
        System.out.println(sb.toString());
    }
}
