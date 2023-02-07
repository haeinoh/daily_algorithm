import java.util.Scanner;

public class Main5575 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();

            int h2 = sc.nextInt();
            int m2 = sc.nextInt();
            int s2 = sc.nextInt();

            if(s2 - s  < 0) {
                m2--;
                s = s2 + 60 - s;
            } else s = s2 - s;

            if(m2 - m < 0) {
                h2--;
                m = m2 + 60 - m;
            } else m = m2 - m;

            System.out.println((h2-h) + " " + m + " " + s);
        }
    }
}
