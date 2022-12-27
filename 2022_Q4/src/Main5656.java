import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5656 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while(true) {
            String[] str = bf.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            String s = str[1];
            int b = Integer.parseInt(str[2]);
            if(s.equals("E")) break;
            sb.append("Case ").append(cnt++).append(": ");
            boolean flag = false;
            switch (s) {
                case ">":
                    if(a > b) flag = true;
                    break;
                case ">=":
                    if(a >= b) flag = true;
                    break;
                case "<":
                    if(a < b) flag = true;
                    break;
                case "<=":
                    if(a <= b) flag = true;
                    break;
                case "==":
                    if(a == b) flag = true;
                    break;
                case "!=":
                    if(a != b) flag = true;
                    break;
            }
            if(flag) sb.append("true");
            else sb.append("false");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
