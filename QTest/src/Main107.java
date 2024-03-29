import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main107 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        String rev = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(rev)) System.out.println("YES");
        else System.out.println("NO");
    }
}
