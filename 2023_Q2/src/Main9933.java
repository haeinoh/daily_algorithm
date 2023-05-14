import java.util.HashSet;
import java.util.Scanner;

public class Main9933 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder(sc.next());
            set.add(str.toString());
            if(set.contains(str.reverse().toString())) System.out.println(str.length() + " " + str.charAt(str.length()/2));
        }
    }
}