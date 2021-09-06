import java.util.Arrays;
import java.util.Comparator;

public class Solution85002 {
    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        double[][] arr = new double[weights.length][4];

        for(int i = 0; i < head2head.length; i++) {
            int cnt = 0;
            int wgt = 0;
            int tot = 0;
            for(int j = 0; j < head2head[i].length(); j++) {
                if(i == j || head2head[i].charAt(j) == 'N') continue;
                if(head2head[i].charAt(j) == 'W') {
                    cnt++;
                    if(weights[i] < weights[j]) wgt++;
                }
                tot++;
            }

            arr[i][0] = i; // 번호
            arr[i][1] = weights[i]; // 무게
            arr[i][2] = (tot == 0) ? 0 : cnt/(double)tot; // 승률
            arr[i][3] = wgt; // 무거운 복서를 이긴 횟수
        }

        Arrays.sort(arr, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[2] == o2[2]) {
                    if(o1[3] == o2[3]) {
                        if(o1[1] == o2[1]) {
                            return Double.compare(o1[0], o2[0]);
                        } return Double.compare(o2[1], o1[1]);
                    } return Double.compare(o2[3], o1[3]);
                }
                return Double.compare(o2[2] , o1[2]);
            }
        });

        for(double[] p : arr) System.out.println(Arrays.toString(p));

        for(int i = 0; i < arr.length; i++) answer[i] = (int) arr[i][0]+1;
        return answer;
    }
    public static void main(String[] args) {
        int[] w = {60, 70, 60};
        String[] h = {"NNN", "NNN", "NNN"};
        System.out.println(Arrays.toString(solution(w, h)));
    }
}
