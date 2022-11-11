import java.util.Scanner;

public class Main5988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            if(Character.getNumericValue(str.charAt(str.length()-1)) % 2 == 0) System.out.println("even");
            else System.out.println("odd");
        }
    }
}
