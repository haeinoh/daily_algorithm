import java.util.Scanner;

public class Main3003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            if(i == 0 || i == 1) sb.append(1-sc.nextInt()).append(" ");
            else if(i == 2 || i == 3 || i == 4) sb.append(2-sc.nextInt()).append(" ");
            else sb.append(8-sc.nextInt()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
