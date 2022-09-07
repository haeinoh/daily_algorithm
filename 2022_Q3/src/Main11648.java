import java.util.Scanner;

public class Main11648 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int answer = 0;
        while(str.length() > 1) {
            int value = 1;
            for(int i = 0; i < str.length(); i++) {
                value *= Character.getNumericValue(str.charAt(i));
            }
            str = String.valueOf(value);
            answer++;
        }
        System.out.println(answer);
    }
}
