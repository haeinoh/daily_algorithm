import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11319 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());

        for(int i = 0; i < n; i++) {
            String s = bf.readLine();
            s  = s.toLowerCase().replaceAll(" ", "");
            int con = s.length();
            s = s.replaceAll("a", "").replaceAll("e", "").replaceAll("o", "")
                    .replaceAll("i", "").replaceAll("u", "");
            System.out.println(s.length() + " " + (con-s.length()));
        }
    }
}
