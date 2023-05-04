import java.util.Scanner;

public class Main5928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt()*1440 + sc.nextInt()*60 + sc.nextInt();
        int start = 11*1440+11*60+11;
        if(sum - start < 0) System.out.println("-1");
        else System.out.println(sum - start);
    }
}
