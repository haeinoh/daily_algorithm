import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main23235 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = 1;
        while(true) {
            String str = bf.readLine();
            if(str.equals("0")) break;
            System.out.println("Case " + n++ + ": Sorting... done!");
        }
    }
}
