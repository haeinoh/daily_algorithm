import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main5972 {
    static class Cow implements Comparable<Cow>{
        int route;
        int cost;

        public Cow(int route, int cost) {
            this.route = route;
            this.cost = cost;
        }


        @Override
        public int compareTo(Cow o) {
            return this.cost - o.cost;
        }
    }
    public static int N, M;
    public static int[] dist;
    public static List<List<Cow>> list;
    public static void solve() {
        PriorityQueue<Cow> pq = new PriorityQueue<>();
        boolean[] vtd = new boolean[N+1];
        dist[1] = 0;
        pq.add(new Cow(1, 0));

        while(!pq.isEmpty()) {
            Cow c = pq.poll();

            if(vtd[c.route]) continue;
            vtd[c.route] = true;

            for(Cow nx: list.get(c.route)) {
                if(dist[nx.route] > nx.cost + dist[c.route]) {
                    dist[nx.route] = nx.cost + dist[c.route];
                    pq.add(new Cow(nx.route, dist[nx.route]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            dist[i] = 987654321;
            list.add(new ArrayList<>());
        }

        for(int i  = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Cow(b, c));
            list.get(b).add(new Cow(a, c));
        }

        solve();
        System.out.println(dist[N]);
    }
}

