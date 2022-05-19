import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main801 {
    public static int N, total;
    public static int[] arr;
    public static boolean[] vtd;
    public static boolean flag;
    public static void DFS(int cnt, int sum) {
        if(flag) return; // flag == true 되버리면 그 뒤로 밑에 안 나려가고 다 스택에서 pop
        if(cnt >= 1 && cnt <= N) {
            if(total - sum == sum) flag = true;
        }

        for(int i = 0; i < N; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                DFS(cnt+1, sum+arr[i]);
                vtd[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        vtd = new boolean[N];

        DFS(0, 0);

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
