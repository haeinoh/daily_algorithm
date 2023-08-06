import java.util.Scanner;

public class Main6750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        boolean flag = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != 'S'&& str.charAt(i) != 'H' && str.charAt(i) != 'I'
            && str.charAt(i) != 'O' && str.charAt(i) != 'Z' && str.charAt(i) != 'X'
            && str.charAt(i) != 'N') {
                flag = true;
                break;
            }
        }
        if(flag) System.out.println("NO");
        else System.out.println("YES");
    }
}
