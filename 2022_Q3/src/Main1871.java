import java.util.Scanner;

public class Main1871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            String[] arr = sc.next().split("-");
            String front = arr[0];
            int value = Integer.parseInt(arr[1]);
            int answer = 0;
            for(int j = 0; j < front.length(); j++) {
                answer += (front.charAt(j)-65)*Math.pow(26, (front.length() - j - 1));
            }
            if(Math.abs(answer - value) <= 100) System.out.println("nice");
            else System.out.println("not nice");
        }
    }
}
