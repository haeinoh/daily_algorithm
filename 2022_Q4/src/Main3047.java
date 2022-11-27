import java.util.Arrays;
import java.util.Scanner;

public class Main3047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();

        Arrays.sort(arr);

        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
           sb.append(arr[str.charAt(i) - 'A']).append(" ");
        }
        System.out.println(sb.toString());
    }
}
