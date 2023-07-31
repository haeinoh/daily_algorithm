import java.util.Scanner;

public class Main25870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[26];
        int even = 0;
        int odd = 0;
        for(int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)-97]++;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                if(arr[i] % 2 == 0) even++;
                else odd++;
            }
        }

        if(even > 0 && odd == 0) System.out.println("0");
        else if(even == 0 && odd > 0) System.out.println("1");
        else System.out.println("2");
    }
}
