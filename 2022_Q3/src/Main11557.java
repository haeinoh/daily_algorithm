import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11557 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int ts = 1; ts <= N; ts++) {
            st = new StringTokenizer(bf.readLine());
            int S = Integer.parseInt(st.nextToken());

            String univ = "";
            int answer = 0;
            for(int i = 0; i < S; i++) {
                st = new StringTokenizer(bf.readLine());
                String str = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                if(answer < value) {
                    univ = str;
                    answer = value;
                }
            }
            System.out.println(univ);
        }
    }
}
