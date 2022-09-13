import java.util.Scanner;

public class Main5354 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            int value = sc.nextInt();
            for(int j = 0; j < value; j++) System.out.print("#");
            System.out.println();
            for(int j = 0; j < value - 2; j++) {
                System.out.print("#");
                for(int k = 0; k < value - 2; k++) System.out.print("J");
                System.out.println("#");
            }
            if(value != 1) for(int j = 0; j < value; j++) System.out.print("#");
            System.out.println();
            if(value == 3 || value == 2) System.out.println();
        }
    }
}
