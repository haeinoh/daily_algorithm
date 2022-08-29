import java.util.Scanner;

public class Main5789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            str = str.substring(str.length()/2-1, str.length()/2+1);
            if(str.charAt(0) == str.charAt(1)) System.out.println("Do-it");
            else System.out.println("Do-it-Not");
        }
    }
}
