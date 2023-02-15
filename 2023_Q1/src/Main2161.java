import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) q.add(i);

        while(!q.isEmpty()) {
            list.add(q.poll());
            if(q.isEmpty()) break;
            q.add(q.poll());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append(list.get(i)).append(" ");

        System.out.println(sb.toString());
    }
}
