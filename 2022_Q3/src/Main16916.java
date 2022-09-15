import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        st = new StringTokenizer(bf.readLine());
        String target = st.nextToken();

        if(str.contains(target)) System.out.println("1");
        else System.out.println("0");
    }
}
