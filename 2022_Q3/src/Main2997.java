import java.util.Arrays;
import java.util.Scanner;

public class Main2997 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int val = arr[1] - arr[0];
        int val2 = arr[2] - arr[1];
        if(val < val2) System.out.println(arr[2] - val);
        else if(val > val2) System.out.println(arr[0] + val2);
        else System.out.println(arr[2] + val);
    }
}
