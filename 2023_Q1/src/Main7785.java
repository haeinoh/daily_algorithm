import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main7785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeSet<String> set = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            String status = sc.next();

            if(status.equals("enter")) set.add(name);
            else set.remove(name);
        }

        Iterator<String> iter = set.iterator();

        StringBuilder str = new StringBuilder();
        while(iter.hasNext()) str.insert(0, iter.next() + "\n");

        System.out.println(str);
    }
}
