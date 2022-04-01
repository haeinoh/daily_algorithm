import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main108 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().toLowerCase();
        StringBuilder org = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if((ch >= 'a' && ch <='z') || (ch >= 'A' && ch <= 'Z')) org.append(ch);
        }
        StringBuilder rev = new StringBuilder(org).reverse();
        if(org.toString().equals(rev.toString())) System.out.println("YES");
        else System.out.println("NO");
    }
}
