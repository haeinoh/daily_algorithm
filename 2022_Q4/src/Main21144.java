import java.util.Scanner;

public class Main21144 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        int value = 1;
        for(int i = 0; i < str.length(); ) {
            if(!str.substring(i, i+String.valueOf(value).length()).equals(String.valueOf(value))) {
                break;
            }
            i += String.valueOf(value).length();
            value++;
        }
        System.out.println(value);
    }
}
