import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main20056 {
    static class Ball {
        int r;
        int c;
        int m;
        int s;
        int d;

        public Ball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public Ball(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static LinkedList<Ball>[][] list;
    public static Queue<Ball> q;
    public static int N, M, K, answer;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void move() {
        int size = q.size();
        while(size > 0) {
            Ball b = q.poll();
            assert b != null;
            int r = b.r;
            int c = b.c;
            int m = b.m;
            int s = b.s;
            int d = b.d;
//            System.out.println("전 " + r + " " + c);
            r += (dx[d] * (s % N));
            c += (dy[d] * (s % N));
            r = (r < 0) ? N+r : r;
            c = (c < 0) ? N+c : c;
            r = (r == N) ? r-N : r;
            c = (c == N) ? c-N : c;
//            System.out.println("후 : " + r + " " + c);
            q.add(new Ball(r, c, m, s, d));
            size--;
        }
    }

    public static void merge() {
        answer = 0;
        while(!q.isEmpty()) {
            Ball b = q.poll();
            int r = b.r;
            int c = b.c;
            int m = b.m;
            int s = b.s;
            int d = b.d;
//            System.out.println(r + " " + c + " " + m + " " + s /+ " " +d);
            list[r][c].add(new Ball(r, c, m, s, d));
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(list[i][j].size() == 1) {
                    Ball b = list[i][j].peek();
                    q.add(new Ball(b.r, b.c, b.m, b.s, b.d));
                } else if(list[i][j].size() > 1) {
                    int size = list[i][j].size();
                    int mass = 0;
                    int speed = 0;
                    List<Integer> dir = new ArrayList<>();
                    for(int k = 0; k < list[i][j].size(); k++) {
                        Ball b = list[i][j].get(k);
                        mass += b.m;
                        speed += b.s;
                        dir.add(b.d);
                    }
                    mass /= 5;
                    speed /= size;
//                    System.out.println("RESULT : " + mass + " " + speed);
                    int base = dir.get(0) % 2;
                    int flag = 0;
                    // dir
                    if(mass != 0) {
                        // 짝수 / 홀수가 다르면
                        for(int p = 1; p < dir.size(); p++) {
                            if(dir.get(p) % 2 != base) {
                                flag = 1;
                                break;
                            }
                        }
//                        System.out.println("우커ㅔ " + base + " " +flag);
                        for(int p = flag; p < 8; p+=2) {
                            q.add(new Ball(i, j, mass, speed, p));
                        }
                    }
                }
            }
        }
        Queue<Ball> temp = new LinkedList<>(q);
        while(!temp.isEmpty()) {
            Ball b = temp.poll();
            answer += b.m;
        }
    }

    public static void init() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                list[i][j] = new LinkedList<>();

    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new LinkedList[N][N];
        q = new LinkedList<>();
        answer = 0;
        init();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q.add(new Ball(r, c, m, s, d));
        }

        while (K >= 0) {
            move();
            merge();
            K--;
            init();
        }
        System.out.println(answer);
    }
}
