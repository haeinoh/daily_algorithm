import java.util.Scanner;

public class Main17202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        StringBuilder line = new StringBuilder();

        for(int i = 0; i < a.length(); i++) {
            line.append(a.charAt(i)).append(b.charAt(i));
        }

        while(line.length() > 2) {
            StringBuilder tmp = new StringBuilder();

            for(int i = 0; i < line.length()-1; i++) {
                tmp.append((Integer.parseInt(String.valueOf(line.charAt(i))) + Integer.parseInt(String.valueOf(line.charAt(i+1))))%10);
            }

            line = tmp;
        }
        System.out.println(line);
    }
}
