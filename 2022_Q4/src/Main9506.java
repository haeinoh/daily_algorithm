import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main9506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = sc.nextInt();
            if(n == -1) break;

            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 1; i <= Math.sqrt(n); i++) {
                if(n % i == 0) {
                    list.add(i);
                    list.add(n/i);
                }
            }

            Collections.sort(list);
            int sum = 0;
            StringBuilder ans = new StringBuilder();
            ans.append(n).append(" = ");
            for(int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                ans.append(list.get(i));
                if(i != list.size()-2) ans.append(" + ");
            }
            ans.append("\n");

            if(sum == n) sb.append(ans);
            else sb.append(n).append(" is NOT perfect.\n");
        }
        System.out.println(sb.toString());
    }
}
