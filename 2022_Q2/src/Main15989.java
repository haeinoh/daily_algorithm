import java.util.Arrays;
import java.util.Scanner;

public class Main15989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];
        for(int i = 0; i < T; i++) arr[i] = sc.nextInt();
        int[] memo = new int[Arrays.stream(arr).max().getAsInt()+1];

 }
}
