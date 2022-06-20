import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int  compare(String o1, String o2) {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append("\n");
        for(int i = 1; i < arr.length; i++) {
            if(arr[i].equals(arr[i-1])) continue;
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
