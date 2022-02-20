import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2480 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if(arr[0] == arr[1] && arr[1] == arr[2]) System.out.println(10000 + arr[0]*1000);
        else if(arr[0] != arr[1] && arr[0] != arr[2] && arr[1] != arr[2]) System.out.println(arr[2]*100);
        else {
            if(arr[0] == arr[1]) System.out.println(1000 + arr[0] * 100);
            else if(arr[1] == arr[2]) System.out.println(1000 + arr[2] * 100);
        }
    }
}
