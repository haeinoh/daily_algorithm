import java.util.Arrays;

public class Solution42842 {
    public static int[] solution(int brown, int yellow) {
        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if((yellow % i == 0) && (brown == ((yellow/i+i)*2 + 4))) {
                return new int[]{yellow/i+2, i+2};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int b = 8;
        int y = 1;
        System.out.println(Arrays.toString(solution(b, y)));
    }
}
