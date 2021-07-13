import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2630 {
    public static int N, white, blue;
    public static int[][] arr;
    public static void solve(int size, int x, int y) {
        if(size == 1) {
            if(arr[x][y] == 0) white++;
            else blue++;
            return;
        }
        if(check(size, x, y, arr[x][y])) {
            return;
        }

        solve(size/2, x, y);
        solve(size/2, x, y+size/2);
        solve(size/2, x+size/2, y);
        solve(size/2, x+size/2, y+size/2);
    }

    public static boolean check(int size, int x, int y, int color) {
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[i][j] != color) return false;
            }
        }
        if(color == 0) white++;
        else blue++;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken().trim());
        white = 0;
        blue = 0;
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(N, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }
}
