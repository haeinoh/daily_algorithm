import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main105_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if(!Character.isAlphabetic(arr[left])) left++;
            else if(!Character.isAlphabetic(arr[right])) right--;
            else {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        System.out.println(String.valueOf(arr));
    }
}