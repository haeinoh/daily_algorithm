import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            list.add(str.substring(i, str.length()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) sb.append(list.get(i)).append("\n");

        System.out.println(sb.toString());
    }
}
