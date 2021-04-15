//https://programmers.co.kr/learn/courses/30/lessons/43162
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution43162 {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        List<List<Integer>> list = new ArrayList<>();
        //init
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(computers[i][j] == 1) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }

        boolean vtd[] = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(!vtd[i]) {
                q.add(i);
                vtd[i] = true;
                while(!q.isEmpty()) {
                    int x = q.poll();

                    for(int value: list.get(x)) {
                        if(!vtd[value]){
                            q.add(value);
                            vtd[value] = true;
                        }
                    }
                }
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] com = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, com));
    }
}
