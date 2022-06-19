import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main1753_buffered {
    public static int V, E, sx;
    public static int[] dist;
    public static List<List<Route>> list;
    static class Route implements Comparable<Route> {
        int v;
        int w;

        public Route(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Route o) {
            return this.w - o.w;
        }
    }
    public static void solve() {
        boolean[] vtd = new boolean[V+1];
        PriorityQueue<Route> pq = new PriorityQueue<>();
        dist[sx] = 0;
        pq.add(new Route(sx, 0));

        while(!pq.isEmpty()) {
            int cur = pq.poll().v;

            if(vtd[cur]) continue;
            vtd[cur] = true;

            for(Route r: list.get(cur)) {
                if(dist[r.v] > dist[cur] + r.w) {
                    dist[r.v] = dist[cur] + r.w;
                    pq.add(new Route(r.v, dist[r.v]));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        dist = new int[V+1];

        list = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
            dist[i] = 987654321;
        }

        st = new StringTokenizer(bf.readLine());
        sx = Integer.parseInt(st.nextToken());

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Route(v, w));
        }

        solve();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
            if(dist[i] == 987654321) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
