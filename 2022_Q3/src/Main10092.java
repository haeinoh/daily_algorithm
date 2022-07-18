import java.util.Scanner;

public class Main10092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) sb.append(" ");
            sb.append("*");
            for(int j = 0; j < i*2-1; j++) sb.append(" ");
            if(i != 0) sb.append("*");
            sb.append("\n");
        }
        if(n != 1) for(int i = 0; i < n*2-1; i++) sb.append("*");
        else System.out.println("*");
        sb.append("\n");
        System.out.println(sb.toString());
    }
}
