import java.util.Arrays;

public class Solution70129 {
    static int[] solution(String s) {
        int count = 0;
        int remove = 0;
        while(!s.equals("1")) {
            int tmp = s.length();
            s = s.replaceAll("0", "");
            remove += (tmp - s.length());
            s = Integer.toBinaryString(s.length());
            count++;
        }
        return new int[]{count, remove};
    }
    public static void main(String[] args) {
        String s = "01110";
        System.out.println(Arrays.toString(solution(s)));
    }
}
