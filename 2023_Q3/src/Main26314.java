import java.util.Scanner;

public class Main26314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String a = sc.next();
            int vowels = 0;
            int consontants = 0;
            for(int j = 0; j < a.length(); j++) {
                if(a.charAt(j) == 'a' || a.charAt(j) == 'e' || a.charAt(j) == 'i' || a.charAt(j) == 'o' || a.charAt(j) == 'u') vowels++;
                else consontants++;
            }
            System.out.println(a);
            if(vowels > consontants) System.out.println("1");
            else System.out.println("0");
        }
    }
}
