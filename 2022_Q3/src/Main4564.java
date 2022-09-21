import java.util.Scanner;

public class Main4564 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            if(n == 0) break;
            StringBuilder sb = new StringBuilder();
            sb.append(n).append(" ");
            while(String.valueOf(n).length() > 1) {
                int tmp = 1;
                for(int i = 0; i < String.valueOf(n).length(); i++) {
                    tmp *= Character.getNumericValue(String.valueOf(n).charAt(i));
                }
                sb.append(tmp).append(" ");
                n = tmp;
            }
            System.out.println(sb.toString());
        }
    }
}
