import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main708 {
    public static int S, E, answer;
    public static int[] dx = {1, -1, 5};
    public static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        boolean[] vtd = new boolean[10001];
        vtd[S] = true;
        loop:while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int x = q.poll();
                if(x == E) break loop;

                for(int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    if(nx  <= 0 || nx > 10000 || vtd[nx]) continue;
                    vtd[nx] = true;
                    q.offer(nx);
                }
                size--;
            }
            answer++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        answer = 0;

        BFS();

        System.out.println(answer);
    }
}
