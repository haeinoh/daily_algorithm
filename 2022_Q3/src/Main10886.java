import java.util.Scanner;

public class Main10886 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[2];
        for(int i = 0; i < N; i++) {
            arr[sc.nextInt()]++;
        }
        if(arr[0] < arr[1]) System.out.println("Junhee is cute!");
        else System.out.println("Junhee is not cute!");
    }
}
