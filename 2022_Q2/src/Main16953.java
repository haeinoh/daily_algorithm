import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        Queue<Long> q = new LinkedList<>();
        q.add((long) a);

        int count = 0;
        boolean flag = false;

        loop:while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                long tmp = q.poll();
                if(tmp*2 < b) q.add(tmp*2);
                else if(tmp*2 == b) {
                    flag = true;
                    break loop;
                }

                Long num = Long.parseLong(String.valueOf(tmp)+"1");
                if(num < b) q.add(num);
                else if(num == b) {
                    flag = true;
                    break loop;
                }
                size--;
            }
            count++;
        }

        if(flag) System.out.println(count+2);
        else System.out.println("-1");
    }
}
