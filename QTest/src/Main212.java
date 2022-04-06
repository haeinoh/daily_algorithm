import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main212 {
    public static int N, M, answer;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        answer = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = i+1; j < N; j++) {
                list.add(arr[0][j]);
            }
            for(int j = 1; j < M; j++) {
                for(int k = 0; k < N; k++) {
                    if(arr[j][k] == arr[0][i]) break;
                    if(list.contains(arr[j][k])) list.remove(list.indexOf(arr[j][k]));
                }
            }
            answer += list.size();
        }
        System.out.println(answer);
    }
}
