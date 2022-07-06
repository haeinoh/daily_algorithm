import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while ((str = bf.readLine()) != null) {
            int[] arr = new int[4];
            for (int i = 0; i < str.length(); i++) {
                if (Character.isLowerCase(str.charAt(i))) arr[0]++;
                else if (Character.isUpperCase(str.charAt(i))) arr[1]++;
                else if (Character.isDigit(str.charAt(i))) arr[2]++;
                else arr[3]++;
            }
            sb.append(arr[0]).append(" ").append(arr[1]).append(" ").append(arr[2]).append(" ").append(arr[3]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
