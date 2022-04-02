import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main112 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        String str = bf.readLine().toString();
        String answer = "";
        for(int i = 0; i < str.length() - 1; i+=7) {
            String tmp = str.substring(i, i+7).replace('#', '1').replace('*', '0');
            String bin = "";
            // 1
//            for(char x : tmp.toCharArray()) {
//                bin += (x == '#' ? '1' : '0');
//            }
            // 2
            int decimal = Integer.parseInt(bin, 2);
            //3
            answer += (char) decimal;
        }

        System.out.println(answer);
    }
}
