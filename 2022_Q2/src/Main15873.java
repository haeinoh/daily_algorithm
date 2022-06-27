import java.util.Scanner;

public class Main15873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(str.length() == 2) System.out.println(Integer.parseInt(str.substring(0,1))+Integer.parseInt(str.substring(1,2)));
        else if(str.length() == 3){
            if(str.charAt(1) == '0') System.out.println(10 + Character.getNumericValue(str.charAt(2)));
            else System.out.println(Character.getNumericValue(str.charAt(0)) + 10);
        } else System.out.println(20);
    }
}
