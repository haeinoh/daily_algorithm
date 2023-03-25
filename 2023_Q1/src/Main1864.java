import java.util.HashMap;
import java.util.Scanner;

public class Main1864 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('-', 0);
        map.put('\\', 1);
        map.put('(', 2);
        map.put('@', 3);
        map.put('?', 4);
        map.put('>', 5);
        map.put('&', 6);
        map.put('%', 7);
        map.put('/', -1);
        while(true) {
            String str = sc.next();
            if(str.equals("#")) break;
            int sum = 0;

            for(int i = 0; i < str.length(); i++) {
                sum += map.get(str.charAt(i))*Math.pow(8, str.length()-i-1);
            }
            System.out.println(sum);
        }
    }
}
