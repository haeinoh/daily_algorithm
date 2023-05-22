import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();

        StringBuilder answer = new StringBuilder();
        String tmp = "";
        boolean flag = false;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!flag && ch == ' ' && !tmp.equals("")) {
              answer.append(tmp).append(" ");
              tmp = "";
            } else if(ch == '<') {
                answer.append(tmp);
                flag = true;
                tmp = "";
                tmp += "<";
            }
            else if(ch == '>') {
                tmp += ">";
                answer.append(tmp);
                flag = false;
                tmp = "";
            } else if(flag) tmp += ch;
            else tmp = ch + tmp;
        }
        if(!tmp.equals("")) answer.append(tmp);
        System.out.println(answer);
    }
}
