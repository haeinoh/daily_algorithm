import java.util.Scanner;

public class Main4575 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String str = sc.nextLine();
            if(str.equals("END")) break;

            char[] arr = str.toCharArray();
            int[] cnt = new int[26];
            boolean flag = false;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == ' ') continue;
                int num = (int)(arr[i]-'0'-17);
                if(cnt[num] == 1) {
                    flag = true;
                    break;
                } else cnt[num] = 1;
            }
            if(!flag) System.out.println(str);
        }
    }
}
