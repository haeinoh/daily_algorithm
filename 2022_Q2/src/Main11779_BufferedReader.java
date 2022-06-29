import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11779_BufferedReader {
    static class Route implements Comparable<Route>{
        int num;
        int cost;
        List<Integer> bus = new ArrayList<>();

        public Route(int num, int cost, List<Integer> bus) {
            this.num = num;
            this.cost = cost;
            this.bus = bus;
        }

        @Override
        public int compareTo(Route o) {
            return this.cost - o.cost;
        }
    }
    public static int N, M;
    public static List<List<Route>> list;
    public static List<Integer> answer;
    public static PriorityQueue<Route> pq;
    public static int[] dist;
    public static void solve(int start, int end) {
        pq = new PriorityQueue<>();
        pq.add(new Route(start, 0, answer));
        dist[start] = 0;
        boolean[] vtd = new boolean[N+1];
        while(!pq.isEmpty()) {
            Route r = pq.poll();

            if(vtd[r.num]) continue;
            vtd[r.num] = true;

            for(Route ro: list.get(r.num)) {
                if(dist[ro.num] > dist[r.num] + ro.cost) {
                    dist[ro.num] = dist[r.num] + ro.cost;
                    List<Integer> tmp = new ArrayList<>(r.bus);
                    tmp.add(ro.num);
                    if(ro.num == end) {
                        answer = tmp;
                    }
                    pq.add(new Route(ro.num, dist[ro.num], tmp));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new int[N+1];
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            dist[i] = 987654321;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Route(b, c, new ArrayList<>()));
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        answer.add(start);

        solve(start, end);

        System.out.println(dist[end]);
        System.out.println(answer.size());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.size(); i++)  sb.append(answer.get(i)).append(" ");
        System.out.println(sb.toString());
    }
}