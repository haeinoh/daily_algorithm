import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution86052 {
    public static int R, C;
    public static int[] dx = {-1, 0, 1, 0}; //up, left, down, right
    public static int[] dy = {0, -1, 0, 1};
    public static boolean[][][] vtd;
    public static ArrayList<Integer> list;
    public static void solve(int x, int y, int dir, String[] grid) {
        int cnt = 0;
        while(true) {
            if(vtd[x][y][dir]) break;

            cnt++;
            vtd[x][y][dir] = true;

            char ch = grid[x].charAt(y);
            if(ch == 'L') dir = (dir == 3) ? 0 : (dir + 1);
            else if(ch == 'R') dir = (dir == 0) ? 3 : (dir - 1);

            x = (x + dx[dir] + R) % R;
            y = (y + dy[dir] + C) % C;
        }
        list.add(cnt);
    }

    public static int[] solution(String[] grid) {
        list = new ArrayList<>();

        R = grid.length;
        C = grid[0].length();
        vtd = new boolean[R][C][4];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                for(int k = 0; k < 4; k++) {
                    if(!vtd[i][j][k]) {
                        solve(i, j, k, grid);
                    }
                }
            }
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }

    public static void main(String[] args) {
//        String[] g = {"SL","LR"};
        String[] g = {"R","R"};
        System.out.println(Arrays.toString(solution(g)));
    }
}
