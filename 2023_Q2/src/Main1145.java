import java.util.Scanner;

public class Main1145 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for(int i = 0; i < 5; i++) arr[i] = sc.nextInt();

        int answer = 0;
        loop:for(int i = 1; ; i++) {
            int count = 0;
            for(int j = 0; j < 5; j++) {
                if(i % arr[j] == 0) count++;
                if(count == 3) {
                    answer = i;
                    break loop;
                }
            }
        }
        System.out.println(answer);
    }
}
