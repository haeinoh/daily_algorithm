import java.util.Scanner;

public class Main11367 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            sb.append(sc.next()).append(" ");
            int value = sc.nextInt();
            if(value >= 97) sb.append("A+");
            else if(value >= 90) sb.append("A");
            else if(value >= 87) sb.append("B+");
            else if(value >= 80) sb.append("B");
            else if(value >= 77) sb.append("C+");
            else if(value >= 70) sb.append("C");
            else if(value >= 67) sb.append("D+");
            else if(value >= 60) sb.append("D");
            else sb.append("F");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
