import java.util.*;
public class Solution42861_Kruskal {
    static int[] parent;
    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) { // y > x
        x = find(x);
        y = find(y);

        if(x != y) parent[y] = x;
    }

    static int solution(int n, int[][] costs) {
        int answer = 0;
        // 1) 간선 리스트의 가중치를 기준으로 오름차순 정렬
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        // union-find (parent[] init)
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        // 2) 가중치가 작은 간선부터 선택
        for(int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int weight = costs[i][2];

            // 3) 부모노드가 같지 않은 경우 연결
            if(find(start) != find(end)) {
                if(start > end) {
                    int tmp = end;
                    end = start;
                    start = tmp;
                }
                union(start, end);
                answer += weight;
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
