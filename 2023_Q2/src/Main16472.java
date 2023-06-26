import java.util.Scanner;

public class Main16472 {
    public static int n;
    public static int[] arr, str;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String cat = sc.next();
        arr = new int[26];
        str = new int[cat.length()];
        for(int i = 0; i < cat.length(); i++) str[i] = cat.charAt(i) - 'a';
        int start = 0;
        int end = 0;
        int answer = 0;
        arr[str[0]]++;
        int count = 1;
        while(start <= end) {
            if(count > n) {
                arr[str[start]]--;
                if(arr[str[start]] == 0) count--;
                start++;
            } else {
                answer = Math.max(answer, end-start+1);
                end++;
                if(end == str.length) break;
                if(arr[str[end]] == 0) count++;
                arr[str[end]]++;
            }
        }

        System.out.println(answer);
    }
}
