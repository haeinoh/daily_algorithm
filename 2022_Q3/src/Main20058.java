import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main20058 {
    public static int[][] arr;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int N, Q;
    public static void remove() {


    }

    public static void rotate(int x, int y, int level) {
        int[][] copy = new int[N][N];
        for (int i = 0; i < arr.length; i++) System.arraycopy(arr[i], 0, copy[i], 0, arr[i].length);

        for (int k = 0; k < level / 2; k++) {
            int sx = x + k;
            int sy = y + k;
            System.out.println("============= " + sx + "  " + sy);
            for(int i = sx; i < sx+level; i++) arr[i][sy+level-1] = copy[sx][i];
            System.out.println("1");
            for(int[] p: arr) System.out.println(Arrays.toString(p));

            for(int i = sy; i < sy+level; i++) arr[sx+level-1][i] = copy[level-i-1][sy+level-1];
            System.out.println("2");
            for(int[] p: arr) System.out.println(Arrays.toString(p));

            for(int i = sx; i < sx+level; i++) arr[i][sy] = copy[sx+level-1][i];
            System.out.println("3");
            for(int[] p: arr) System.out.println(Arrays.toString(p));

            for(int i = sy; i < sy+level; i++) arr[sx][sy+level-i+1] = copy[i][sy];
            System.out.println("4");

            for(int[] p: arr) System.out.println(Arrays.toString(p));
        }

        remove();
    }
    public static void solve(int level) {
        level = (int) Math.pow(2, level);

        for(int i = 0; i < N; i+=level) {
            for(int j = 0; j < N; j+= level) {
                rotate(i, j, level);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < Q; i++) {
            int value = Integer.parseInt(st.nextToken());
            solve(value);
        }


        int max = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                max = Math.max(max, arr[i][j]);
                sum += arr[i][j];
            }
        }

        int cnt = 0;

        System.out.println(sum);
        System.out.println(cnt);
    }
}
