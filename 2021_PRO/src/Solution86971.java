import java.util.*;

public class Solution86971 {
    public List<List<Integer>> list;
    public int answer;
    public void cutting(int cut1, int cut2, int n) {
        boolean[] vtd = new boolean[n+1];
        vtd[cut1] = true; // area1
        vtd[cut2] = true; // area2

        Queue<Integer> q = new LinkedList<>();
        q.add(cut1);
        int count = 1;
        while(!q.isEmpty()) {
            int num = q.poll();

            for(int i: list.get(num)) {
                if(!vtd[i]) {
                    q.add(i);
                    vtd[i] = true;
                    count++;
                }
            }
        }
        answer = Math.min(answer, Math.abs((n - count) - count));
    }
    public int solution(int n, int[][] wires) {
        answer = 987654321;
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for(int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }

        for(int i = 0; i < wires.length; i++) {
            cutting(wires[i][0], wires[i][1], n);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
