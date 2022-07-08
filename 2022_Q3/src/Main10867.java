import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main10867 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < N; i++) set.add(sc.nextInt());
        StringBuilder sb = new StringBuilder();
        Iterator iter = set.iterator();
        while(iter.hasNext()) sb.append(iter.next()).append(" ");
        System.out.println(sb.toString());
    }
}
