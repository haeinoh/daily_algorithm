import java.util.Scanner;

public class Main28295 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dir = 0;
        for(int i = 0; i < 10; i++) {
            int tmp = sc.nextInt();
            if(tmp == 1) dir = (dir + 1 > 3) ? 0 : dir + 1;
            else if(tmp == 2) dir = (dir + 2 > 3) ? dir - 2 : dir + 2;
            else dir = (dir - 1 < 0) ? 3 : dir - 1;
        }

        if(dir == 0) System.out.println("N");
        else if(dir == 1) System.out.println("E");
        else if(dir == 2) System.out.println("S");
        else System.out.println("W");
    }
}
