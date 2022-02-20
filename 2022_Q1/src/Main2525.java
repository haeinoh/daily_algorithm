import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2525 {
    public static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken()) * 60;
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        C = Integer.parseInt(st.nextToken());

        int hour = A + B + C;
        int min = hour % 60;

        hour /= 60;
        hour %= 24;

        System.out.println(hour + " " + min);
    }
}
