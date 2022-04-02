import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main108_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().toLowerCase().replaceAll("[^a-z]", "");
        String rev = new StringBuilder(str).reverse().toString();
        if(str.equals(rev)) System.out.println("YES");
        else System.out.println("NO");
    }
}
