import java.util.*;

public class Solution12978 {
    static int[] dist;
    static List<List<Node>> list;
    static class Node implements Comparable<Node> {
        int val;
        int cost;
        public Node(int val, int cost) {
            this.val = val;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; //오름차순
        }
    }
    static int solution(int N, int[][] road, int K) {
        int answer = 0;
        list = new ArrayList<>();
        dist = new int[N+1];
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>()); // init
            dist[i] = 987654321;
        }

        for (int[] ints : road) {
            list.get(ints[0]).add(new Node(ints[1], ints[2]));
            list.get(ints[1]).add(new Node(ints[0], ints[2]));
        }

        boolean[] vtd = new boolean[N+1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        vtd[0] = true;
        dist[1] = 0;
        q.add(new Node(1, 0));

        while(!q.isEmpty()) {
            int cur = q.poll().val;

            if(vtd[cur]) continue;
            vtd[cur] = true;

            for(Node n: list.get(cur)) {
                if(dist[n.val] > dist[cur] + n.cost) {
                    dist[n.val] = dist[cur] + n.cost;
                    q.add(new Node(n.val, dist[n.val]));
                }
            }
        }
        for(int i = 1; i < dist.length; i++) if(dist[i] <= K) answer++;
        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] r = {
                {1,2,1},
                {2,3,3},{5,2,2},
                {1,4,2},{5,3,1},{5,4,2}
        };
        int k = 3;
        System.out.println(solution(N, r, k));
    }
}
