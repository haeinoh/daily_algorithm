import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main26489 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while(true) {
            String str = bf.readLine();
            if(Objects.equals(str, "") || str == null) break;
            cnt++;
        }
        System.out.println(cnt);
    }
}
