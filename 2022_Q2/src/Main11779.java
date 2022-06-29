import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main11779 {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        list = new ArrayList<>();
        dist = new int[N+1];
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            dist[i] = 987654321;
        }

        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.get(a).add(new Route(b, c, new ArrayList<>()));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

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