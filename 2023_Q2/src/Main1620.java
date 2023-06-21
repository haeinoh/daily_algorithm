import java.util.HashMap;
import java.util.Scanner;

public class Main1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> mapOpp = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            String str = sc.next();
            map.put(i, str);
            mapOpp.put(str, i);
        }

        for(int i = 0; i < m; i++) {
            String tmp = sc.next();
            if(Character.isDigit(tmp.charAt(0))) System.out.println(map.get(Integer.parseInt(tmp)));
            else System.out.println(mapOpp.get(tmp));
        }
    }
}
