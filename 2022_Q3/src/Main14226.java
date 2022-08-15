import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main14226 {
    static class Emoticon {
        int val;
        int copy;

        public Emoticon(int val, int copy) {
            this.val = val;
            this.copy = copy;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        Queue<Emoticon> q = new LinkedList<>();
        q.add(new Emoticon(1, 0));

        int time = 0;
        boolean[][] vtd = new boolean[S*2+1][S*2+1];
        loop:while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Emoticon e = q.poll();
                if(e.val == S) break loop;
                if(!vtd[e.val][e.val]) {
                    q.add(new Emoticon(e.val, e.val)); // 1
                    vtd[e.val][e.val] = true;
                }
                if(e.val+e.copy <= S*2 && !vtd[e.val+e.copy][e.copy]) {
                    q.add(new Emoticon(e.val+e.copy, e.copy)); // 2
                    vtd[e.val+e.copy][e.copy] = true;
                }
                if(e.val-1 >= 2 && !vtd[e.val-1][e.copy]) {
                    q.add(new Emoticon(e.val-1, e.copy)); // 3
                    vtd[e.val-1][e.copy] = true;
                }
                size--;
            }
            time++;
        }
        System.out.println(time);
    }
}
