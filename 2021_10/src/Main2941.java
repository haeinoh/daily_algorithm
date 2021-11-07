import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2941 {
    public static String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String str = st.nextToken();
        for (String s : arr) {
            if (str.contains(s)) str = str.replaceAll(s, "X");
        }
        System.out.println(str.length());
    }
}
