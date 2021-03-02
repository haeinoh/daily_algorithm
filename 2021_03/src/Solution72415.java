import java.util.LinkedList;
import java.util.Queue;

public class Solution72415 {
    static class Card {
        int x;
        int y;
        int[][] arr;
        int ox;
        int oy;
        public Card(int x, int y, int[][] arr, int ox, int oy) {
            this.x = x;
            this.y = y;
            this.arr = arr;
            this.ox = ox;
            this.oy = oy;
        }
    }
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static boolean check(int[][] arr) {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(arr[i][j] != 0) return false;
            }
        }
        return true;
    }

    public static int solution(int[][] board, int r, int c) {
        int answer = 0;
        Queue<Card> q = new LinkedList<>();
        q.add(new Card(r, c, board, -1, -1));

        loop:while (!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Card tmp = q.poll();
                int x = tmp.x;
                int y = tmp.y;
                int[][] arr = tmp.arr;
                int ox = tmp.ox;
                int oy = tmp.oy;

                if(check(arr)) break loop;

                if(ox != -1 && oy != -1 && ox != x && oy != y && arr[x][y] != 0) { //오픈된 카드가 있는데 현재 카드를 뒤집을 수 있는 경우
                    if(arr[x][y] == arr[ox][oy]) { // 카드가 맞으면 둘 다 사라짐
                        arr[x][y] = 0;
                        arr[ox][oy] = 0;
                    }
                    // 카드가 맞든 틀리든 ox, oy 초기
                    ox = -1;
                    oy = -1;
                    q.add(new Card(x, y, arr, ox, oy));
                } else if(ox == -1 && oy == -1 && arr[x][y] != 0) { // 오픈된 카드가 없는데 현재 카드를 뒤집을 수 있는 경우
                    ox = x;
                    oy = y;
                    q.add(new Card(x, y, arr, ox, oy));
                } else {
                    for(int i = 0; i < 4; i++) {
                        int idx = 0;
                        for(int k = 1; k < 4; k++) {
                            int nx = x + dx[i] * k;
                            int ny = y + dy[i] * k;

                            if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
                                idx = k-1;
                                break;
                            }

                            if(arr[nx][ny] != 0) { // 이동하다가 카드를 만난 경우
                                idx = k;
                                q.add(new Card(nx, ny, arr, ox, oy));
                            }
                        }

                        q.add(new Card(x+dx[i]*idx, y+dy[i]*idx, arr, ox, oy));
                    }
                }
                size--;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int bo[][] = {
                {1,0,0,3},
                {2,0,0,0},
                {0,0,0,2},
                {3,0,1,0}
        };

        int r = 1;
        int c = 0;

        System.out.println(solution(bo, r, c));
    }
}
