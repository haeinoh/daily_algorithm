import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[9][9];

        int col = 0;
        int row = 0;
        int max = -1;
        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(max < num) {
                    col = i+1;
                    row = j+1;
                    max = num;
                }
            }
        }
        System.out.println(max);
        System.out.println(col + " " +row);
    }
}
