//https://www.acmicpc.net/problem/2110
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110 {
    public static int N, C, arr[];
    public static boolean make(int gap) {
        int prev = arr[0];
        int count = 0; // count 공유기
        for(int i = 1; i < N; i++) {
            if(arr[i] - prev >= gap) { // 현재 값 - prev가 gap보다 크거나 같아야한다.
                count++;
                prev = arr[i]; // 다음 gap을 구한다
            }
        }
        return count >= C;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st.nextToken().trim());
        }

        Arrays.sort(arr); // 오름차순 정렬

        C--; // 무조건 첫 번째에 공유기를 설치한다고 가정한다.
        int start = 1;
        int end = arr[N-1] - arr[0];
        int answer = 0;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(make(mid)) { // 공유기가 C보다 더 많이 설치되었다면
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else end = mid - 1; // 만들 수 없다면 간격이 너무 크다라는 의미이므로, 간격을 좁힌다.
        }
        System.out.println(answer);
    }
}
