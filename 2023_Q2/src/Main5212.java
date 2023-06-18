import java.util.Scanner;

public class Main5212 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] arr = new char[n][m];

        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            for(int j = 0; j < m; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        int sx  = 101;
        int sy = 101;
        int ex = -1;
        int ey = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int count = 0;
                if(arr[i][j] == 'X') {
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == '.') count++;
                    }
                    if(count >= 3) arr[i][j] = '-';
                    else {
                        sx = Math.min(sx, i);
                        sy = Math.min(sy, j);
                        ex = Math.max(ex, i);
                        ey = Math.max(ey, j);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = sx; i <= ex; i++) {
            for(int j = sy; j <= ey; j++) {
                if(arr[i][j] == '-') sb.append(".");
                else sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
