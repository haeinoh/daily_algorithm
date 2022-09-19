import java.util.Scanner;

public class Main10801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int a = 0;
        int b = 0;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < arr.length; i++) {
            int tmp = sc.nextInt();
            if(arr[i] < tmp) b++;
            else if(arr[i] > tmp) a++;
        }
        if(a > b) System.out.println("A");
        else if(a < b) System.out.println("B");
        else System.out.println("D");
    }
}
