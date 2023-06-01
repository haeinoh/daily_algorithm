import java.util.Scanner;

public class Main4613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String str = sc.nextLine();
            if(str.equals("#")) break;
            int sum = 0;
            for(int i = 1; i <= str.length(); i++) {
                char ch = str.charAt(i-1);
                if(ch == ' ') continue;
                sum += i*((int)(ch-'0')-16);
            }
            System.out.println(sum);
        }
    }
}
