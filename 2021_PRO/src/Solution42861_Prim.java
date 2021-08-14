import java.util.*;

public class Solution42861_Prim {
    static class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    static int solution(int n, int[][] costs) {
        int answer = 0;
        // 가중치 오름차순 정렬
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        List<List<Edge>> list = new ArrayList<>();

        // init
        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for(int i = 0; i < costs.length; i++) {
            list.get(costs[i][0]).add(new Edge(costs[i][1], costs[i][2]));
            list.get(costs[i][1]).add(new Edge(costs[i][0], costs[i][2]));
        }

        boolean[] vtd = new boolean[n];

        //임의의 정점 하나 선택
        pq.add(new Edge(0,0));

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(vtd[e.target]) continue;
            vtd[e.target] = true;
            answer += e.weight;

            for(Edge edge: list.get(e.target)) {
                if(!vtd[edge.target]) pq.add(new Edge(edge.target, edge.weight));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] c = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n, c));
    }
}
