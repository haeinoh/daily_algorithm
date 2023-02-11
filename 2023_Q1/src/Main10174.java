import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10174 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            StringBuilder rev = new StringBuilder(bf.readLine().toLowerCase());
            StringBuilder str = new StringBuilder(rev);
            if(str.compareTo(rev.reverse()) == 0) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
