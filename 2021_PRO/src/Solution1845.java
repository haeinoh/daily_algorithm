import java.util.HashSet;

public class Solution1845 { 
    public static int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);
        answer = Math.min(set.size(), nums.length / 2);

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        System.out.println(solution(nums));
    }
}
