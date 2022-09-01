import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17284 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int money = 5000;
        while(st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            if(value == 1) money -= 500;
            else if(value == 2) money -= 800;
            else money -= 1000;
        }
        System.out.println(money);
    }
}
