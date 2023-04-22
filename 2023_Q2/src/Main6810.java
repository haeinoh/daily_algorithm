import java.util.Scanner;

public class Main6810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[13];
        arr[0] = 9;
        arr[1] = 7;
        arr[2] = 8;
        arr[3] = 0;
        arr[4] = 9;
        arr[5] = 2;
        arr[6] = 1;
        arr[7] = 4;
        arr[8] = 1;
        arr[9] = 8;

        for(int i = 0; i < 3; i++) arr[i+10] = sc.nextInt();

        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) sum += arr[i]*1;
            else sum += arr[i]*3;
        }

        System.out.println("The 1-3-sum is " + sum);
    }
}
