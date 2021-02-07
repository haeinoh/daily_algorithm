//https://www.acmicpc.net/problem/3025
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3025 {
    public static int R, C;
    public static char arr[][];

    public static void drop(int row) {
        loop:for(int i = 0; i < R-1; i++) {
            if(arr[i+1][row] == '.' && (i+1) == R-1) { // 돌이 가장 아랫줄에 있다면
                arr[i+1][row] = 'O';
                break loop;
            }
            if(arr[i+1][row] == 'X') {
                arr[i][row] = 'O';
                break loop;
            }
            if(arr[i+1][row] == '.') continue; // 돌의 아랫칸이 비어있다면
            if(arr[i+1][row] == 'O') { // 돌의 아랫칸에 돌이 있다면
                if(row > 0 && arr[i][row-1] == '.' && arr[i+1][row-1] == '.') {
                    row--;
                    if((i+1) == R-1) arr[i+1][row] = 'O';
                } else if(row < R-1 && arr[i][row+1] == '.' && arr[i+1][row+1] == '.') {
                    row++;
                    if((i+1) == R-1) arr[i+1][row] = 'O';
                } else {
                    arr[i][row] = 'O';
                    break loop;
                }
            }
            /*for(char p[]: arr) System.out.println(Arrays.toString(p));
            System.out.println();*/
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        for(int i = 0; i < R; i++) {
            String str = String.valueOf(new StringTokenizer(bf.readLine()).nextToken());
            for(int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int N = Integer.parseInt(new StringTokenizer(bf.readLine().trim()).nextToken());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(new StringTokenizer(bf.readLine().trim()).nextToken());
            drop(x-1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
