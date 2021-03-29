import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main19236 {
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int answer;

    public static class Fish {
        int x;
        int y;
        int dir;
        int eat;
    }

    public static void solve(int[][] tmp, Fish[] tmpFish, int eatTotal) {

        int[][] arr = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                arr[i][j] = tmp[i][j];
            }
        }

            Fish[] fish = new Fish[17];
            for(int i = 0; i < 17; i++) {
                fish[i] = new Fish();
                if(tmpFish[i].eat == -1) continue;
                fish[i].x = tmpFish[i].x;
                fish[i].y = tmpFish[i].y;
                fish[i].dir = tmpFish[i].dir;
                fish[i].eat = tmpFish[i].eat;
            }

            //switch fish position
            for(int ts = 1; ts <= 16; ts++) {
                
                if(fish[ts].eat != -1) { //죽은 물고기가 아닌 경우
                    int x = fish[ts].x;
                    int y = fish[ts].y;
                    int dir = fish[ts].dir;

                    for(int i = 0; i < 8; i++) {
                        if(dir == 8) dir -= 8;
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if(nx >= 0 && ny >=  0 && nx < 4 && ny < 4 && arr[nx][ny] >= 0) {
                            if(arr[nx][ny] == 0) {
                                arr[fish[ts].x][fish[ts].y] = 0;
                                fish[ts].x = nx;
                                fish[ts].y = ny;
                            } else {
                                int num = arr[nx][ny];
                                fish[num].x = fish[ts].x;
                                fish[num].y = fish[ts].y;
                                arr[fish[ts].x][fish[ts].y] = num;

                                fish[ts].x = nx;
                                fish[ts].y = ny;
                            }
                            arr[nx][ny] = ts;
                            break;
                        }
                        dir++;
                    }
                }
            }
        for(int p[]: arr) System.out.println(Arrays.toString(p));
        System.out.println();
        for(int i = 1; i <= 3; i++) {
            int nx = fish[0].x + dx[fish[0].dir]*i;
            int ny = fish[0].y + dy[fish[0].dir]*i;
            // 상어가 갈 다음 칸이 경계값을 넘어가면 break
            if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) break;
            // 상어가 갈 다음 칸이 빈칸이거나, 죽은 물고기면 패쓰?
            if(arr[nx][ny] == 0) continue;
            // 먹을 수 있는 물고기가 있다면, 물고기의 번호만큼 먹고 물고기의 방향값 까지 갖는다.
            int deadNum = arr[nx][ny];
            arr[fish[0].x][fish[0].y] = 0;
            fish[0].x = nx;
            fish[0].y = ny;
            fish[0].dir = fish[deadNum].dir;
            fish[0].eat += deadNum;
            // arr의 값은 -1이 된다.
            arr[nx][ny] = -1;
            fish[deadNum].eat = -1;
            System.out.println("---- " + fish[0].eat);
            for(int p[]: arr) System.out.println(Arrays.toString(p));
            System.out.println();
            solve(arr, fish, eatTotal+deadNum);
            // 상어는 먹은만큼 다시 빼야하고, 방향값과 위치를 이전으로 되돌려야하고
            fish[0].eat -= deadNum;
            fish[0].x = tmpFish[0].x;
            fish[0].y = tmpFish[0].y;
            fish[0].dir = tmpFish[0].dir;
            // 죽었던 물고기를 살려야한다.
            fish[deadNum].eat = 0;
            // -1이 된 arr값을 원래 물고기의 번호대로 돌려놓는다.
            arr[nx][ny] = deadNum;
            //상어는 다시 -1이된다.
            arr[tmpFish[0].x][tmpFish[0].y] = -1;
        }
        answer = Math.max(answer, fish[0].eat);
//        for(int p[]: arr) System.out.println(Arrays.toString(p));
       /* for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                tmp[i][j] = arr[i][j];
            }
        }

        for(int i = 0; i < 17; i++) {
            tmpFish[i].x = fish[i].x;
            tmpFish[i].y = fish[i].y;
            tmpFish[i].dir = fish[i].dir;
            tmpFish[i].eat = fish[i].eat;
        }*/
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[4][4];
        Fish[] fish = new Fish[17];
        answer = 0;
        for(int i = 0; i < 17; i++) fish[i] = new Fish();

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;

                if(i == 0 && j == 0) {
                    fish[0].x = 0;
                    fish[0].y = 0;
                    fish[0].dir = dir;
                    fish[0].eat = num;
                    fish[num].eat = -1; // 먹힘
                    arr[i][j] = -1;
                } else {
                    fish[num].x = i;
                    fish[num].y = j;
                    fish[num].dir = dir;
                    arr[i][j] = num;
                }
            }
        }

        solve(arr, fish, fish[0].eat);
        System.out.println(answer);
    }
}
