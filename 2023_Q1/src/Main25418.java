import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main25418 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        q.add(a);

        int count = 0;
        boolean[] vtd = new boolean[b+1];
        vtd[a] = true;
        loop:while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int tmp = q.poll();

                if(tmp + 1  == b|| tmp * 2 == b) {
                    count++;
                    break loop;
                }
                if(tmp+1 <= b && !vtd[tmp+1]) {
                    q.add(tmp + 1);
                    vtd[tmp+1] = true;
                }
                if(tmp*2 <= b && !vtd[tmp*2]) {
                    q.add(tmp * 2);
                    vtd[tmp*2] = true;
                }
                size--;
            }
            count++;
        }

        System.out.println(count);
    }
}
