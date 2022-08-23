import java.util.Scanner;

public class Main17009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int apple = 0;
        for(int i = 3; i > 0; i--) apple += (sc.nextInt()*i);
        int banana = 0;
        for(int i = 3; i > 0; i--) banana += (sc.nextInt()*i);
        if(apple > banana) System.out.println("A");
        else if(apple < banana) System.out.println("B");
        else System.out.println("T");
    }
}
