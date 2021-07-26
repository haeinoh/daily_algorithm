public class Solution12953 {
    static int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int g = gcd(answer, arr[i]);
            answer = (answer / g) * (arr[i]/g) * g;
        }

        return answer;
    }

    static int gcd(int min, int max) {
        while(min != 0) {
            int tmp = max % min;
            max = min;
            min = tmp;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        System.out.println(solution(arr));
    }
}
