import java.util.Scanner;

public class Main25024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(x >= 0 && x <= 23 && y >= 0 && y <= 59) sb.append("Yes ");
            else sb.append("No ");

            boolean flag = false;
            if((x == 1 || x == 3 || x == 5 || x == 7 || x == 8 || x == 10 || x == 12) && y >= 1 && y <= 31) flag = true;
            else if(x == 2 && y >= 1 && y <= 29) flag = true;
            else if((x == 4 || x == 6 || x == 9 || x == 11 ) && y >= 1 && y <= 30) flag = true;

            if(flag) sb.append("Yes");
            else sb.append("No");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
