//https://www.acmicpc.net/problem/1525
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1525 {
    public static int arr[][], ans[][], answer;
    public static boolean flag;
    public static Queue<int[]> q;
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, -1, 0, 1};

    public static void init() {
        int num = 1;
        loop:for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 2 && j == 2) break loop;
                ans[i][j] = num;
                num++;
            }
        }
    }

    public static boolean check() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(arr[i][j] != ans[i][j]) return false;

        return true;
    }

    public static void solve() {
        int time = 0;
        loop:while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int tmp[] = q.poll();
                int x = tmp[0];
                int y = tmp[1];

                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || ny < 0 || nx >= 3 || ny >=3 ) continue;

                    if(arr[nx][ny] == ans[x][y]) {
                        q.add(new int[]{nx, ny});
                        arr[x][y] = arr[nx][ny];
                        arr[nx][ny] = 0;
                    }
                }
                size--;
            }
            time++;
            if(check()) {
                flag = true;
                answer = time;
                break loop;
            }
            if(time > 8) {
                break loop;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[3][3];
        ans = new int[3][3];
        answer = 0;
        q = new LinkedList<>();
        flag = false;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
            }
        }
        init();
        solve();
        if(flag) System.out.println(answer);
        else System.out.println("-1");
    }
}