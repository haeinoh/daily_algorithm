import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main9517 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < 8; i++) {
            if(k > 8) {
                k = 1;
            }
            q.add(k++);
        }

        int time = 0;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int sec = sc.nextInt();
            String str = sc.next();
            if(time >= 210 && answer == 0) {
                answer = q.poll();
            } else if(str.equals("P") || str.equals("N")) {
                time += sec;
                if(time >= 210 && answer == 0) {
                    answer = q.peek();
                }
            } else if(str.equals("T")) {
                int num = q.poll();
                time += sec;
                if(time >= 210 && answer == 0) {
                    answer = num;
                }
                q.add(num);
            }
        }
        System.out.println(answer);
    }
}
