import java.util.HashSet;
import java.util.Scanner;

public class Main2774 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            String str = sc.next();
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                set.add(ch);
            }
            System.out.println(set.size());
        }
    }
}
