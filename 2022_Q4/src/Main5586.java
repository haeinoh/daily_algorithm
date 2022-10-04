import java.util.Scanner;

public class Main5586 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int jcnt = 0;
        int icnt = 0;
        for(int i = 0; i < str.length() - 2; i++) {
            if(str.charAt(i) == 'J' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I') jcnt++;
            else if(str.charAt(i) == 'I' && str.charAt(i+1) == 'O' && str.charAt(i+2) =='I') icnt++;
        }
        System.out.println(jcnt);
        System.out.println(icnt);
    }
}
