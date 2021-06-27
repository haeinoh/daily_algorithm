import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12851 {
    public static int N, K;
    public static int[] dir = {2, -1, 1};
    public static boolean[] vtd;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        vtd = new boolean[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        vtd[N] = true;

        int time = 0;
        int count = 0;
        if(N == K) {
            count = 1;
        } else {
            while(!q.isEmpty()) {
                int size = q.size();
                count = 0;
                boolean flag = false;
                while(size > 0) {
                    int x = q.poll();
                    vtd[x] = true;
                    int nx = 0;
                    for(int i = 0; i < dir.length; i++) {
                        if(i == 0) {
                            nx = x * dir[i];
                        } else {
                            nx = x + dir[i];
                        }
                        if(nx < 0 || nx > 100000) continue;
                        if(nx == K) {
                            flag = true;
                            count++;
                        }
                       if(!vtd[nx]) {
                            q.add(nx);
                        }
                    }
                    size--;
                }
                time++;
                if(flag) break;
            }
        }

        System.out.println(time);
        System.out.println(count);
    }
}
