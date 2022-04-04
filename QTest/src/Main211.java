import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Main211 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        int answer = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] res = new int[N];
        for(int i = 0; i < N; i++) {
            int[] tmp = new int[10];
            for(int j = 0; j < N; j++) {
                tmp[arr[j][i]]++;
            }
            for(int j = 0; j < N; j++) {
                if(tmp[arr[j][i]] >= 2) {
                    res[j]+=tmp[arr[j][i]]-1;
                }
            }
        } 

        int max = -987654321;
        for(int i = 0; i <  N; i++) {
            if(max < res[i]) {
                max = res[i];
                answer = i;
            }
        }
        System.out.println(answer+1);
    }
}
