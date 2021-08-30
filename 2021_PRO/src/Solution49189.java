import java.util.*;

public class Solution49189 {
    static int solution(int n, int[][] edge) {
        int answer = 1;
        int[] dist = new int[n+1];
        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vtd = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            dist[i] = 987654321;
        }

        for(int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }

        q.add(1);
        dist[0] = 0;
        dist[1] = 0;
        while(!q.isEmpty()) {
            int tmp = q.poll();
            if(vtd[tmp]) continue;
            vtd[tmp] = true;
            for(int val: list.get(tmp)) {
                if(dist[val] > dist[tmp] + 1) {
                    dist[val] = dist[tmp] + 1;
                    q.add(val);
                }
            }
        }
        Arrays.sort(dist);
        int value = dist[dist.length - 1];
        for(int i = dist.length - 2; i >= 0; i--) {
            if(value == dist[i]) answer++;
            else break;
        }

        return answer;
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] e = {
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        };
        System.out.println(solution(n, e));
    }
}
