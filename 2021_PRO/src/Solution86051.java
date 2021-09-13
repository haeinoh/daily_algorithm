public class Solution86051 {
    static int solution(int[] numbers) {
        int answer = 45;
        for(int num: numbers) answer -= num;
        return answer;
    }
    public static void main(String[] args) {
        int[] n = {1,2,3,4,6,7,8,0};
        System.out.println(solution(n));
    }
}
