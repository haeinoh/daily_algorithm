import java.util.Scanner;

public class Main15814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int N = sc.nextInt();
        char[] arr = new char[str.length()];
        for(int i = 0; i < str.length(); i++) arr[i] = str.charAt(i);
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            char tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) sb.append(arr[i]);
        System.out.println(sb.toString());
    }
}
