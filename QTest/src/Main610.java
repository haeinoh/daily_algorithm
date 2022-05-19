import java.util.Arrays;
import java.util.Scanner;

public class Main610 {
    public static int N, C;
    public static int[] arr;
    public static int count(int dist) { // dist : 가장 가까운 말의 거리 (answer)
        int cnt = 1; // 배치한 말의 수
        int endPos = arr[0]; // 바로 전에 배치한 말의 좌표
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - endPos >= dist) {
                cnt++;
                endPos = arr[i];
            }
        }
        return cnt;
    }
    public static int solve() {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[N-1];

        while(lt <= rt) {
            int mid = (lt + rt) >> 1;
            if(count(mid) >= C) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid -1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
        System.out.println(solve());
    }
}
