import java.util.Scanner;

public class Main14405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.replaceAll("pi", "_");
        str = str.replaceAll("ka", "_");
        str = str.replaceAll("chu", "_");

        boolean flag = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '_') {
                flag = true;
                break;
            }
        }
        if(!flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
