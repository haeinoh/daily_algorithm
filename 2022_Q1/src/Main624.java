import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main624 {
    public static int[][] arr = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}
    };
    public static int T;
    public static String A, B;
    public static int minus (int a, int b) {
        int count = 0;
        if(a >= 0 && b >= 0) {
            for(int i = 0; i < 7; i++) if(arr[a][i] != arr[b][i]) count++;
        } else for(int j = 0; j < 7; j++) count += arr[a][j];
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int ts = 1; ts <= T; ts++) {
            st = new StringTokenizer(bf.readLine());
            A = st.nextToken();
            B = st.nextToken();

            int answer = 0;
            int alen = A.length() - 1;
            int blen = B.length() - 1;
            while(true) {
                if(alen < 0 && blen < 0) break;
                if(alen >= 0 && blen >= 0) answer += minus(Character.getNumericValue(A.charAt(alen)), Character.getNumericValue(B.charAt(blen)));
                else if(alen < 0) answer += minus(Character.getNumericValue(B.charAt(blen)), -1);
                else if(blen < 0) answer += minus(Character.getNumericValue(A.charAt(alen)), -1);
                alen--;
                blen--;
            }
            System.out.println(answer);
        }
    }
}
