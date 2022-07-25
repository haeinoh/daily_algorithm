import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(sc.nextInt());

        }
        System.out.println(pq.toString());
    }
}
