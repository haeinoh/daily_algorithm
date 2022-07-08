import java.util.Scanner;

public class Main2953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int max = 0;
        for(int i = 0; i < 5; i++) {
            int sum = 0;
            for(int j = 0; j < 4; j++) sum += sc.nextInt();
            if(max < sum) {
                max = sum;
                answer = i+1;
            }
        }
        System.out.println(answer + " " + max);
    }
}
