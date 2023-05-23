import java.util.Scanner;

public class Main17828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[50];

        for(int i = 0; i < 50; i++) arr[i] = sc.nextInt();

        int k = sc.nextInt();

        int idx = 0;
        for(int i = 0; i < 50; i++) {
            if(k == arr[i]) {
                idx = i+1;
                break;
            }
        }

        if(idx >= 1 && idx <= 5) System.out.println("A+");
        else if(idx >= 6 && idx <= 15) System.out.println("A0");
        else if(idx >= 16 && idx <= 30) System.out.println("B+");
        else if(idx >= 31 && idx <= 35) System.out.println("B0");
        else if(idx >= 36 && idx <= 45) System.out.println("C+");
        else if(idx >= 46 && idx <= 48) System.out.println("C0");
        else if(idx >= 49) System.out.println("F");
    }
}
