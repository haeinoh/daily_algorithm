import java.util.Scanner;

public class Main2511 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for(int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();

        int aCnt = 0;
        int bCnt = 0;
        int win = 0;
        for(int i = 0; i < arr.length; i++) {
            int val = sc.nextInt();
            if(arr[i] > val) {
                aCnt += 3;
                win = 1;
            } else if(arr[i] < val) {
                bCnt += 3;
                win = 2;
            } else {
                aCnt++;
                bCnt++;
            }

            if(i == arr.length-1) {
                System.out.println(aCnt + " " + bCnt);
                if(aCnt == bCnt && aCnt == 10) System.out.println("D");
                else if((aCnt == bCnt && win == 1) || aCnt > bCnt) System.out.println("A");
                else System.out.println("B");
            }
        }
    }
}
