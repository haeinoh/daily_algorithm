import java.util.Arrays;

public class Solution42747_2 {
    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int index = 0;
        for(index = citations.length - 1; index >= 0; index--) {
            if(citations[index] < citations.length - index) break;
        }
        return citations.length - index - 1;
    }
    public static void main(String[] args) {
        int[] c = {11, 22};
        System.out.println(solution(c));
    }
}
