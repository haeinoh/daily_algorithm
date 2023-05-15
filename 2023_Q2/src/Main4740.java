import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4740 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = bf.readLine();
            if(str.equals("***")) break;

            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse());
        }
    }
}
