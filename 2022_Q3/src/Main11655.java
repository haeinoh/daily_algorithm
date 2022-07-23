import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                int tmp = ch + 13;
                tmp = (tmp > 90) ? (tmp-91+65) : tmp;
                sb.append((char)tmp);
            } else if(ch >= 'a' && ch <= 'z'){
                int tmp = ch + 13;
                tmp = (tmp > 122) ? (tmp-123+97) : tmp;
                sb.append((char)tmp);
            } else sb.append(ch);
        }


        System.out.println(sb.toString());
    }
}
