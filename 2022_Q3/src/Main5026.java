import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5026 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken().trim());
        for(int i = 0; i < N; i++) {
            String str = bf.readLine();
            if(str.contains("+")) {
                String[] tmp = str.split("\\+");
                System.out.println(Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]));
            } else System.out.println("skipped");
        }
    }
}
