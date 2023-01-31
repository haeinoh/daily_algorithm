import java.util.HashMap;
import java.util.Scanner;

public class Main10570 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int ts = 1; ts <= T; ts++) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                int value = sc.nextInt();
                map.put(value, map.getOrDefault(value, 0) + 1);
            }

            int answer = 0;
            int max = 0;
            for(Integer val: map.keySet()) {
                if(map.get(val) >= max) {
                    if(map.get(val) == max) answer = Math.min(answer, val);
                    else {
                        max = map.get(val);
                        answer = val;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
