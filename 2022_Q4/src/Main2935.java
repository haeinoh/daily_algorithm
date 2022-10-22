import java.util.Scanner;

public class Main2935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String str = sc.next();
        String b = sc.next();
        StringBuilder sb = new StringBuilder();
        if(str.equals("*")) {
            sb.append("1");
            for(int i = 0; i < a.length()+b.length()-2; i++) sb.append("0");
        } else {
            if(a.equals("1") && b.equals("1")) sb.append("2");
            else {
                int val = 0;
                if(a.length() >= b.length()) val = a.length();
                else val = b.length();
                for(int i = val; i > 0; i--) {
                    if(a.length() == b.length() && i == a.length()) sb.append("2");
                    else if(i == a.length() || i == b.length()) sb.append("1");
                    else sb.append("0");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
