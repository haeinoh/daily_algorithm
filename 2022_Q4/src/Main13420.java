import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main13420 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String[] arr = bf.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[2]);
            int c = Integer.parseInt(arr[4]);

            switch (arr[1]) {
                case "+":
                    if(a + b == c) sb.append("correct\n");
                    else sb.append("wrong answer\n");
                    break;
                case "-":
                    if(a - b == c) sb.append("correct\n");
                    else sb.append("wrong answer\n");
                    break;
                case "/":
                    if(a / b == c) sb.append("correct\n");
                    else sb.append("wrong answer\n");
                    break;
                case "*":
                    if(a * b == c) sb.append("correct\n");
                    else sb.append("wrong answer\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
