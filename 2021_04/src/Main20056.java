//https://www.acmicpc.net/problem/20056
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
            // 이동 좌표 계산 - 연결되어 있음
            r += (dx[d] * (s % N));
            c += (dy[d] * (s % N));
            r = (r < 0) ? N+r : r;
            c = (c < 0) ? N+c : c;
            r = (r >= N) ? r-N : r;
            c = (c >= N) ? c-N : c;
            q.add(new Ball(r, c, m, s, d)); // q에 현재 파이어볼 정보 담기
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
            list[r][c].add(new Ball(r, c, m, s, d)); // q에 있는 것들 list 좌표 값에 맞춰서 옮기기
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int size = list[i][j].size();
                if(size > 1) { // 해당 좌표에 2개 이상의 파이어볼이 있다면
                    int mass = 0;
                    int speed = 0;
                    List<Integer> dir = new ArrayList<>();
                    for(int k = 0; k < list[i][j].size(); k++) {
                        Ball b = list[i][j].get(k);
                        mass += b.m; // 질량 합
                        speed += b.s; // 속도 합
                        dir.add(b.d); // dir 임시저장
                    }
                    mass /= 5;
                    speed /= size;
                    int base = dir.get(0) % 2; // dir 첫 번째 기준으로
                    int flag = 0; // 같으면 짝수
                    // dir
                    if(mass > 0) {
                        // 짝수 / 홀수가 다르면
                        for(int p = 1; p < dir.size(); p++) {
                            if(dir.get(p) % 2 != base) { // 하나라도 다르면 홀수
                                flag = 1;
                                break;
                            }
                        }
                        for(int p = flag; p < 8; p+=2) { // 짝/홀 시작
                            q.add(new Ball(i, j, mass, speed, p));
                        }
                    }
                } else if(size == 1) { // 해당 좌표에 값이 하나밖에 없는 경우 그냥 queue에 넣어
                    q.add(new Ball(i, j, list[i][j].get(0).m, list[i][j].get(0).s, list[i][j].get(0).d));
                }
            }
        }
        Queue<Ball> temp = new LinkedList<>(q); // q 복사
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

       for(int i = 0; i < K; i++) {
            move(); // 이동
            merge(); // 합치고 나누고 ...
            init(); // 좌표에 list 초기화
        }
        System.out.println(answer);
    }
}