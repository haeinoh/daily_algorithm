import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int y = Integer.parseInt(st.nextToken());
        int answer = 0;
        if(x > 0) answer = y > 0 ? 1 : 4;
        else answer = y > 0 ? 2 : 3;
        System.out.println(answer);
    }
}
