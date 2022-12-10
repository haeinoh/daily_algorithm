import java.util.Arrays;
import java.util.Scanner;

public class Main14467 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[11];
        Arrays.fill(arr, -1);
        int answer = 0;
        for(int i = 0; i < N; i++) {
            int cow = sc.nextInt();
            int pos = sc.nextInt();
            if(arr[cow] == -1) arr[cow] = pos;
            else {
                if(arr[cow] != pos) answer++;
                arr[cow] = pos;
            }
        }
        System.out.println(answer);
    }
}
