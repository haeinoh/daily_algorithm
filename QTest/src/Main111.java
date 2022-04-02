import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main111 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().trim();
        char org = str.charAt(0);
        String answer = "";
        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            char target = str.charAt(i);
            if(org == target){
                cnt++;
            } else {
                if(cnt > 1) answer += (org + String.valueOf(cnt));
                else if(cnt == 1) answer += org;
                org = target;
                cnt = 1;
            }
        }
        if(cnt > 1) answer += (org + String.valueOf(cnt));
        else if(cnt == 1) answer += org;

        System.out.println(answer);
    }
}
