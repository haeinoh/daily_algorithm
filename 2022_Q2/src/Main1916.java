import java.util.*;

public class Main1916 {
    public static int N, M;
    public static int[] dist;
    public static List<List<Bus>> list;
    static class Bus implements Comparable<Bus> {
        int v;
        int w;

        public Bus(int v, int w) {
            this.v = v;
            this.w = w;
        }


        @Override
        public int compareTo(Bus o) {
            return this.w - o.w;
        }
    }

    public static void solve(int sx) {
        boolean[] vtd = new boolean[N+1];
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(sx, 0));
        dist[sx] = 0;

        while(!pq.isEmpty()) {
            int cur = pq.poll().v;

            if(vtd[cur]) continue;
            vtd[cur] = true;

            for(Bus b: list.get(cur)) {
                if(dist[b.v] > dist[cur] + b.w) {
                    dist[b.v] = dist[cur] + b.w;
                    pq.add(new Bus(b.v, dist[b.v]));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        dist = new int[N+1];
        list = new ArrayList<>();

        Arrays.fill(dist, 987654321);
        for(int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.get(a).add(new Bus(b, c));
        }

        int sx = sc.nextInt();
        int sy = sc.nextInt();

        solve(sx);

        System.out.println(dist[sy]);
    }
}
