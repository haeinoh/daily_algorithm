import java.util.ArrayList;
import java.util.Arrays;

public class Solution86048 {
    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();
        for(int i = 0; i < enter.length; i++) {
            in.add(enter[i]);
            out.add(leave[i]);
        }
        boolean[][] vtd = new boolean[enter.length][enter.length];
        for(int i = 0; i < enter.length; i++) {
            int outidx = out.indexOf(enter[i]) - 1;
            if(outidx >= 0) {
                int inidx = in.indexOf(out.get(outidx));
                for (int j = i + 1; j <= inidx; j++) {
                    System.out.println((in.get(i)-1) + " " +(in.get(j)-1));
                    vtd[in.get(i)-1][in.get(j)-1] = true;
                    vtd[in.get(j)-1][in.get(i)-1] = true;
                }
            }
        }

        for(int i = 0; i < vtd.length; i++)
            for(int j = 0; j < vtd[i].length; j++)
                if(vtd[i][j]) answer[i]++;

        return answer;
    }

    public static void main(String[] args) {
        int[] e = {3, 2, 1};
        int[] l = {1, 3, 2};
        System.out.println(Arrays.toString(solution(e, l)));
    }
}
