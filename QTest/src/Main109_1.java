import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main109_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().trim();
        int answer = 0;
        for(char x : str.toCharArray()) {
            if(x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }
        System.out.println(answer);
    }
}
