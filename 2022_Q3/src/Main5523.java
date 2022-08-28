import java.util.Scanner;

public class Main5523 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int awin = 0;
        int bwin = 0;

        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a > b) awin++;
            else if(b > a) bwin++;
        }
        System.out.println(awin + " " + bwin);
    }
}
