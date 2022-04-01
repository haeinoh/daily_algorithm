import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main101 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String src = st.nextToken().toLowerCase();
        st = new StringTokenizer(bf.readLine());
        String tar = st.nextToken().toLowerCase();
        int cnt = src.length();
        src = src.replaceAll(tar, "");
        System.out.println(cnt - src.length());
    }
}
