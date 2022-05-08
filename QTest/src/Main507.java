import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main507 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String mandatory = st.nextToken();

        st = new StringTokenizer(bf.readLine());
        String subject = st.nextToken();

        int midx = 0;
        boolean flag = false;
        for(int i = 0; i < subject.length(); i++) {
            if(subject.charAt(i) == mandatory.charAt(midx)) {
                midx++;
            }
            if(midx >= mandatory.length()) {
                flag = true;
                System.out.println("YES");
                break;
            }
        }

        if(!flag) System.out.println("NO");
    }
}
