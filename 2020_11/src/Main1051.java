import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1051 {
    public static int N, M, arr[][], answer;
    public static int dx[] = {1, 1};
    public static int dy[] = {1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        answer = 1;

        for(int i = 0;i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for(int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int num = arr[i][j];

                for(int k = j+1; k< M ;k++) {
                    if(arr[i][k] == num) {
                        int x1 = i + (k-j)*dx[0];
                        int y1 = j + (k-j)*dy[0];
                        int x2 = i + (k-j)*dx[1];
                        int y2 = j + (k-j)*dy[1];
                        if(x1 < N && x2 < N && y1 < M && y2 < M) {
                            if(arr[x1][y1] == num && arr[x2][y2] == num) {
                                answer = Math.max(answer, (k-j+1)*(k-j+1));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}