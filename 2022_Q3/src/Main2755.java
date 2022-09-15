import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2755 {
    public static double solve(String str) {
        switch (str) {
            case "A+" : return 4.3;
            case "A0" : return 4.0;
            case "A-" : return 3.7;
            case "B+" : return 3.3;
            case "B0" : return 3.0;
            case "B-" : return 2.7;
            case "C+" : return 2.3;
            case "C0" : return 2.0;
            case "C-" : return 1.7;
            case "D+" : return 1.3;
            case "D0" : return 1.0;
            case "D-" : return 0.7;
            case "F" : return 0.0;
        }
        return 0.0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        double answer = 0.0;
        int unit = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String tmp = st.nextToken();
            int cls = Integer.parseInt(st.nextToken());
            double grade = solve(st.nextToken());
            unit += cls;
            answer += cls*grade;
        }
        System.out.println(String.format("%.2f", Math.round(answer/unit*100)/100.0));
    }
}
