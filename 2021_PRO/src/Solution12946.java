import java.util.*;
public class Solution12946 {
    static ArrayList<int[]> list;
    static void hanoi(int n, int from, int to , int via) {
        if(n == 1) {
            list.add(new int[]{from , to});
        } else {
            hanoi(n-1, from, via, to);
            list.add(new int[]{from, to});
            hanoi(n-1, via, to , from);
        }
    }

    static int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] r = solution(n);
        for(int p[]: r) System.out.println(Arrays.toString(p));
    }
}
