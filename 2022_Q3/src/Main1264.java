import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = bf.readLine().toLowerCase();
            if(str.equals("#")) break;
            int answer = str.length();
            str = str.replace("a", "");
            str = str.replace("e", "");
            str = str.replace("i", "");
            str = str.replace("o", "");
            str = str.replace("u", "");

            System.out.println(answer-str.length());
        }
    }
}
