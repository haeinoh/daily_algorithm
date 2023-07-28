import java.util.Scanner;

public class Main27918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = false;
        int dal = 0;
        int pho = 0;
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            if(!flag) {
                if(tmp.equals("D")) dal++;
                else pho++;
                if(Math.abs(dal - pho) >= 2) flag = true;
            }
        }
        System.out.println(dal + ":" + pho);
    }
}
