import java.util.Scanner;

public class Main9946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; ; i++) {
            String a = sc.next();
            String b = sc.next();
            if(a.equals("END") && b.equals("END")) break;
            sb.append("Case ").append(i).append(": ");

            if(a.length() == b.length()) {
                a = a.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
                b = b.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
                if(a.equals(b)) sb.append("same");
                else sb.append("different");
            } else sb.append("different");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
