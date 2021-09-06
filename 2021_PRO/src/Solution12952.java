public class Solution12952 {
    static int answer;
    static int[] arr;

    static void solve(int row, int n) {
        if(row == n) {
            answer++;
            return;
        }

        for(int i = 0; i < n; i++) {
            arr[row] = i;
            if(possible(row)) {
                solve(row+1, n);
            }
        }
    }

    static boolean possible(int row) {
        for(int i = 0; i < row; i++) {
            if(arr[row] == arr[i]) return false;
            if(Math.abs(row - i) == Math.abs(arr[row] - arr[i])) return false;
        }
        return true;
    }

    static int solution(int n) {
        answer = 0;
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[0] = i;
            solve(1, n);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }
}
