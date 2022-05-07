import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main503 {
    public static int N, M;
    public static int[][] arr;
    public static int solve(int index) {
        for(int i = 0; i < N; i++) {
            if(arr[i][index-1] != 0) {
                int tmp = arr[i][index-1];
                arr[i][index-1] = 0;
                return tmp;
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());

        int count = 0;
        Stack<Integer> s = new Stack<>();

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < M; i++) {
            int index = Integer.parseInt(st.nextToken());

            int value = solve(index);
            if(value == -1) continue;
            if(!s.isEmpty() && s.peek() == value) {
                s.pop();
                count+=2;
            } else {
                s.push(value);
            }
        }
        System.out.println(count);
    }
}
