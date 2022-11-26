import java.util.Scanner;

public class Main2857 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 5; i++) {
            String str = sc.next();
            if(str.contains("FBI")) sb.append(i+1).append(" ");
        }
        if(sb.length() > 0) System.out.println(sb.toString());
        else  System.out.println("HE GOT AWAY!");

    }
}
