import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String[] str = st.nextToken().split("-");

        Queue<Integer> s = new LinkedList<>();
        for(int i = 0; i < str.length; i++) {
            if(str[i].contains("+")) {
                String[] tmp = str[i].split("\\+");
                int num = 0;
                for(int j = 0; j < tmp.length; j++) {
                    if(!tmp[j].equals("+")) {
                        num += Integer.parseInt(tmp[j]);
                    }
                }
                s.offer(num);
            } else s.offer(Integer.parseInt(str[i]));
        }
        int answer = s.poll();
        while(!s.isEmpty()) answer -= s.poll();

        System.out.println(answer);
    }
}
