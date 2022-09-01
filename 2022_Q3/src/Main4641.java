import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main4641 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = bf.readLine();
            if(str.equals("-1")) break;
            StringTokenizer st = new StringTokenizer(str);
            ArrayList<Integer> list = new ArrayList<>();
            while(st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 0) break;
                list.add(value);
            }
            int count = 0;
            for(int i = 0; i < list.size() - 1; i++) {
                for(int j = i+1; j < list.size(); j++) {
                    if(list.get(i)*2 == list.get(j)) count++;
                    else if(list.get(i) == list.get(j) * 2) count++;
                }
            }
            System.out.println(count);
        }
    }
}
