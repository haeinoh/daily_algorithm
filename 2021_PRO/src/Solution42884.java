import java.util.Arrays;
import java.util.Comparator;

public class Solution42884 {
    static int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int start = routes[0][1];
        for(int i = 1; i < routes.length; i++) {
            if(routes[i][0] > start) {
                start = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] r = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(r));
    }
}
