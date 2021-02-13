//https://www.acmicpc.net/problem/1561
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1561 {
    public static int M, arr[], answer;
    public static long N;
    public static long sum(long mid) { // 현재 분 수에서의 아이들의 총합
        long ans = 0;
        for(int i = 0; i < M; i++) ans += mid / arr[i]; // (분 수) / (놀이기구 운행시간)
        return ans+M; // 0분(+M)
    }

    public static int calc(long cur, long mid) { // cur : (mid-1)분의 아이들 총 수 + 1
        for(int i = 0; i < M; i++) {
            if(mid % arr[i] == 0) { // 0으로 나누어 떨어지는 경우는 아이들이 놀이기구를 탑승하는 경우
                if(cur == N) return i; // 찾고자 하는 아이가 타는 놀이기구 번호를 알게 되면 return
                else cur++;
            }
        }
        return -1; // 못 찾은 경우
    }

    public static void search() {
        long start = 1;
        long end = 2000000000L*30L; // end값은 N*M으로 잡아햔다.

        while(start <= end) {
            long mid = (start + end) >> 1;
            long next = sum(mid); // 현재 분 수에서 아이들의 총합
            if(N <= next) { // 구하려는 번호보다 아이들의 총합이 더 크거나 같은 경우
                int ans = calc(sum(mid-1)+1, mid); // 현재 (분 수의 -1분)의 아이들의 총합 +1이 현재 분 수의 시작 분 수
                if(ans == -1) end = mid - 1; // 만약 N을 못 찾았다면
                else { // 찾았다면
                    answer = ans+1;
                    break;
                }
            }
            else start = mid +1;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        answer = 0;
        st= new StringTokenizer(bf.readLine());
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(N <= M) answer = (int) N; // N <= M보다 작은 경우는 그냥 N이 답이다.
        else search();
        System.out.println(answer);
    }
}
