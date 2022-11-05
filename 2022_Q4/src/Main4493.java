import java.util.Scanner;

public class Main4493 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int a = 0;
            int b = 0;
            for(int j = 0; j < n; j++) {
                String aa = sc.next();
                String bb = sc.next();
                if(aa.equals(bb)) continue;
                if((aa.equals("R") && bb.equals("P")) || (aa.equals("P") && bb.equals("S")) ||
                        (aa.equals("S") && bb.equals("R"))) b++;
                else a++;
            }
            if(a < b) System.out.println("Player 2");
            else if(a > b) System.out.println("Player 1");
            else System.out.println("TIE");
        }
    }
}
