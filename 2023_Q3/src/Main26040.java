import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main26040 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();

        ArrayList<String> list = new ArrayList<>();

        st = new StringTokenizer(bf.readLine());

        while(st.hasMoreTokens()) {
            String tmp = st.nextToken();
            list.add(tmp);
        }


        for(int i = 0; i < list.size(); i++) {
            if(str.contains(list.get(i))) {
                str = str.replaceAll(list.get(i), list.get(i).toLowerCase());
            }
        }
        System.out.println(str);
    }
}
