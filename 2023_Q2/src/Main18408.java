import java.util.Scanner;

public class Main18408 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int one = 0;
        int two = 0;
        for(int i = 0; i < 3; i++)  {
            if(sc.nextInt() == 1) one++;
            else two++;
        }
        if(one > two) System.out.println("1");
        else System.out.println("2");
    }
}
