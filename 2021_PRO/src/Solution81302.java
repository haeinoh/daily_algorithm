import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution81302 {
    public static Character[][] arr;
    public static boolean[][] vtd;
    public static Queue<int[]> q, f;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void init(String[][] places, int x) {
        for(int i = 0; i < 5; i++) {
           String tmp  = places[x][i];
           for(int j = 0; j < 5; j++) {
               arr[i][j] = tmp.charAt(j);
               vtd[i][j] = false; // init
               if(arr[i][j] == 'P') f.add(new int[]{i, j}); // P
           }
        }
    }
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        arr = new Character[5][5];
        vtd = new boolean[5][5];
        q = new LinkedList<>();

        for(int i = 0; i < places.length; i++) {
            f = new LinkedList<>();
            init(places, i);
            boolean flag = false;
            loop:while(!f.isEmpty()) {
                int[] tmp = f.poll();
                int x = tmp[0];
                int y = tmp[1];
                if(!vtd[x][y]) {
                    q = new LinkedList<>();
                    q.add(new int[]{x, y});
                    vtd[x][y] = true;
                    int count = 0;
                    while(!q.isEmpty()) {
                        int size = q.size();
                        while(size > 0) {
                            int[] temp = q.poll();
                            int xx = temp[0];
                            int yy = temp[1];

                            for(int k = 0; k < 4; k++) {
                                int nx = xx + dx[k];
                                int ny = yy + dy[k];

                                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || arr[nx][ny] == 'X') continue;
                                if(!vtd[nx][ny]) {
                                    if(arr[nx][ny] == 'P') {
                                        flag = true;
                                        break loop;
                                    } else {
                                        vtd[nx][ny] = true;
                                        q.add(new int[]{nx, ny});
                                    }
                                }
                            }
                            size--;
                        }
                        count++;
                        if(count == 2) break;
                    }
                }
            }
            if(!flag) answer[i] = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] p = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"},
        };

        System.out.println(Arrays.toString(solution(p)));
    }
}
