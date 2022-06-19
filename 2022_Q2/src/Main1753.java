import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1753 {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        
        dist = new int[V+1];

        list = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
            dist[i] = 987654321;
        }

        sx = sc.nextInt();

        for(int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

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
