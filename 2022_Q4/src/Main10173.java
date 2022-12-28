import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10173 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = bf.readLine();
            if(str.equals("EOI")) break;
            str = str.toUpperCase();
            if(str.contains("NEMO")) System.out.println("Found");
            else System.out.println("Missing");
        }
    }
}
