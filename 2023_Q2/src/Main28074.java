import java.util.Scanner;

public class Main28074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] arr = new int[26];
        for(int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)-'0'-17]++;
        }
        if(arr[12] > 0 && arr[14] > 0 && arr[1] > 0 && arr[8] > 0 && arr[18] > 0) System.out.println("YES");
        else System.out.println("NO");
    }
}
