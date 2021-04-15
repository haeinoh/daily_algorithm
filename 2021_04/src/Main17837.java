import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main17837 {
    public static int N, K;
    public static int[][] arr;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static LinkedList<Integer>[][] list;
    public static Horse[] mal;
    public static class Horse {
        int r;
        int c;
        int dir;

        public Horse(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }

        public Horse() {
        }
    }

    public static boolean check() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(list[i][j].size() >= 4) return true;
            }
        }
        return false;
    }

    public static List<Integer> extract(int base) {
        int x = mal[base].r;
        int y = mal[base].c;
        boolean flag = false;
        List<Integer> tmp = new LinkedList<>();
        for(int i = 0; i < list[x][y].size(); i++) {
            if(list[x][y].get(i) == base) {
                flag = true;
            }
            if(flag) {
                tmp.add(list[x][y].get(i));
            }
        }
        return tmp;
    }

    public static void init() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                list[i][j] = new LinkedList<>();


        for(int i = 0; i <= K; i++) mal[i] = new Horse();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

//        mal = new LinkedList[K+1];
        mal = new Horse[K+1];
        list = new LinkedList[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        init();
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;
            list[r][c].add(i+1);
            mal[i+1].r = r;
            mal[i+1].c = c;
            mal[i+1].dir = d;
        }

        int answer = 0;
        while(true) {
            ++answer;
            for(int i = 1; i <= K; i++) {
                int x = mal[i].r;
                int y = mal[i].c;
                int dir = mal[i].dir;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                int color = -1;
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    color = 2;
                } else {
                    color = arr[nx][ny];
                }

                List<Integer> tmp = extract(i);
                switch(color) {
                    case 0:
                        for(int p = 0; p < tmp.size(); p++) {
                            list[nx][ny].add(tmp.get(p)); // list new add
                            mal[tmp.get(p)].r = nx; // mal r,c change
                            mal[tmp.get(p)].c = ny;
                            list[x][y].remove(tmp.get(p)); // remove original r, c
                        }
                        break;
                    case 1:
                        for(int p = tmp.size()-1; p >=0; p--) {
                            list[nx][ny].add(tmp.get(p)); // list new add
                            mal[tmp.get(p)].r = nx; // mal r,c change
                            mal[tmp.get(p)].c = ny;
                            list[x][y].remove(tmp.get(p)); // remove original r, c
                        }
                        break;
                    case 2:
                        int newDir = (dir % 2 == 0) ? (dir + 1) : (dir - 1);
                        nx = x + dx[newDir];
                        ny = y + dy[newDir];
                        mal[i].dir = newDir;
                        if(nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] != 2) {
                            for(int p = 0; p < tmp.size(); p++) {
                                list[nx][ny].add(tmp.get(p)); // list new add
                                mal[tmp.get(p)].r = nx; // mal r,c change
                                mal[tmp.get(p)].c = ny;
                                list[x][y].remove(tmp.get(p)); // remove original r, c
                            }
                        }
                        break;
                }
            }
            if(check()) break;
            if(answer > 1000) break;
        }
        answer = answer > 1000 ? -1 : answer;
        System.out.println(answer);
    }
}
