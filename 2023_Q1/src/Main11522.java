import java.util.Scanner;

public class Main11522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int value = sc.nextInt();
            sb.append(num).append(" ");
            int sum = 0;
            for(int k = 1; k <= value; k++) sum += k;
            sb.append(sum).append(" ");
            int odd = 0;
            int even = 0;
            for(int k = 1; k <= value*2; k++) {
                if(k % 2 == 0) even += k;
                else odd += k;
            }
            sb.append(odd).append(" ").append(even).append("\n");
        }
        System.out.println(sb.toString());
    }
}
