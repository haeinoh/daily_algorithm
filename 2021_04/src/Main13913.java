import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13913 {
    public static int N, K, count;
    public static Queue<Hide> q;
    public static boolean[] vtd;
    public static String answer;
    public static int[] dir = {2, -1, 1};
    public static class Hide {
        int point;
        String sb;

        public Hide(int point, String sb) {
            this.point = point;
            this.sb = sb;
        }
    }
    public static void solve() {
        String tp = String.valueOf(N);
        q.add(new Hide(N, tp));
        vtd[N] = true;

        loop:while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Hide h = q.poll();
                int p = h.point;
                String s = h.sb;

                if(p == K) {
                    answer = s;
                    break loop;
                }
                int np = 0;

                for(int i = 0; i < 3; i++) {
                    if(i == 0) np = p * dir[i];
                    else np = p + dir[i];
                    if(np >= 0 && np <= 100000 && !vtd[np]) {
                        vtd[np] = true;
                        q.add(new Hide(np, s + " " + np));
                        if(np == K) {
                            answer = (s + " " + np);
                            count++;
                            break loop;
                        }
                    }
                }
                size--;
            }
            count++;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        count = 0;
        q = new LinkedList<>();
        answer = "";
        vtd = new boolean[100001];

        solve();
        System.out.println(count);
        System.out.println(answer);
    }
}
