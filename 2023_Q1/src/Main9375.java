import java.util.HashMap;
import java.util.Scanner;

public class Main9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int ts = 0; ts < T; ts++) {
            int n = sc.nextInt();

            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                String a = sc.next();
                String b = sc.next();

                map.put(b, map.getOrDefault(b, 0) + 1);
            }

            int sum = 1;
            for(String str : map.keySet()) {
                sum *= (map.get(str)+1);
            }

            if(n == 0) System.out.println("0");
            else System.out.println(sum-1);
        }
    }
}
