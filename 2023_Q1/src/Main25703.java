import java.util.Scanner;

public class Main25703 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb.append("int a;\n");
        for(int i = 0; i < n; i++) {
            sb.append("int ");
            for(int j = 0; j <= i; j++) sb.append("*");
            sb.append("ptr");
            if(i >= 1) sb.append(i+1);
            sb.append(" = &");
            if(i == 0) sb.append("a");
            else if(i == 1) sb.append("ptr");
            else sb.append("ptr").append(i);
            sb.append(";\n");
        }
        System.out.println(sb.toString());
    }
}
