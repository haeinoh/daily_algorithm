import java.util.Scanner;

public class Main18406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int sum = 0;
        for(int i = 0; i < str.length() / 2; i++) {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        for(int j = str.length()/2; j < str.length(); j++) {
            sum -= Integer.parseInt(String.valueOf(str.charAt(j)));
        }

        if(sum == 0) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
