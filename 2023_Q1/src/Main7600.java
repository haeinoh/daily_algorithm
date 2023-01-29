import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7600 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = bf.readLine();
            if(str.equals("#")) break;
            str = str.toLowerCase();
            int answer = 0;
            int[] arr = new int[26];
            for(int i = 0; i < str.length(); i++) {
                int tmp = str.charAt(i) -'0' - 49;
                if(tmp >= 0 && tmp <= 26) {
                    if(arr[tmp] == 0) answer++;
                    arr[tmp]++;
                }
            }
            System.out.println(answer);
        }
    }
}
