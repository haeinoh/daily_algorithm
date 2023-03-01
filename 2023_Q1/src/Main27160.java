import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main27160 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String val = sc.next();
            int num = sc.nextInt();
            map.put(val, map.getOrDefault(val, 0) + num);
        }

        boolean flag = false;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 5) {
                flag = true;
                break;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
