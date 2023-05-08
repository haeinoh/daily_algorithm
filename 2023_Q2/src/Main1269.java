import java.util.HashSet;
import java.util.Scanner;

public class Main1269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0; i < n; i++) set.add(sc.nextInt());

        int count = 0;
        for(int j = 0; j < k; j++) {
            int val = sc.nextInt();
            if(set.contains(val)) count++;
        }

        System.out.println(n+k-(count*2));
    }
}
