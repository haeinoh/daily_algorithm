import java.util.Scanner;

public class Main14726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            int sum = 0;
            for(int j = 0; j < str.length(); j++) {
                int num = str.charAt(j)-'0';
                if(j % 2 != 0) sum += num;
                else {
                    if(num * 2 >= 10) {
                        num *= 2;
                        sum += ((num / 10) + (num % 10));
                    } else sum += (num * 2);
                }
            }
            if(sum % 10 == 0) System.out.println("T");
            else System.out.println("F");
        }
    }
}
