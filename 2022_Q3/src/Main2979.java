import java.util.Scanner;

public class Main2979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[101];
        int min = 987654321;
        int max = 0;
        for(int i = 0; i < 3; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            min = Math.min(min, start);
            max = Math.max(max, end);
            for(int j = start; j < end; j++) {
                arr[j]++;
            }
        }
        int answer = 0;
        for(int i = min; i <= max; i++) {
            if(arr[i] == 1) answer += a;
            else if(arr[i] == 2) answer += b*2;
            else if(arr[i] == 3) answer += c*3;
        }
        System.out.println(answer);
    }
}
