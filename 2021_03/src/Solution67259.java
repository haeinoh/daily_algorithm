//https://programmers.co.kr/learn/courses/30/lessons/67259
import java.util.LinkedList;
import java.util.Queue;

public class Solution67259 {
    static class Doro {
        int x;
        int y ;
        int prev;
        int cost;

        public Doro(int x, int y, int prev, int cost) {
            this.x = x;
            this.y = y;
            this.prev = prev;
            this.cost = cost;
        }
    }

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static int solution(int[][] board) {
        int answer = 987654321;

        int N = board.length;
        Queue<Doro> q = new LinkedList<>();
        boolean[][] vtd = new boolean[N][N]; // 방문체크
        int[][] map = new int[N][N]; // 방문한 곳 비용 체크
        q.add(new Doro(0, 0, 2, 0)); // 아래
        q.add(new Doro(0, 0, 3, 0)); // 오른쪽
        vtd[0][0] = true;


        while(!q.isEmpty()) {
            Doro tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            int prev = tmp.prev;
            int cost = tmp.cost;
            if(x == N-1 && y == N-1) answer = Math.min(answer, cost); // 원하는 위치(N-1, N-1)에 도달하면 answer최소값 체크

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //범위를 벗어나거나 || 벽이 있거나 || 거꾸로 돌아가는 경우
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 1 || ((prev+2) % 4 == i)) continue;

                int newCost = cost;
                if((prev % 2 == 0 && i % 2 == 0) || (prev % 2 != 0 && i % 2 != 0)) newCost += 100;
                else newCost += 600;

                if(!vtd[nx][ny]) { // 방문한적이 없다면
                    vtd[nx][ny] = true;
                    map[nx][ny] = newCost;
                    q.add(new Doro(nx, ny, i, newCost));
                } else if (map[nx][ny] >= (newCost)) { // 방문한적이 있다면, 비용 비교해서 갱신
                    map[nx][ny] = newCost;
                    q.add(new Doro(nx, ny, i , newCost));
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
//        int[][] b = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] b = {
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(solution(b));

    }
}
