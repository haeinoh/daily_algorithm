import java.util.Scanner;

public class Main3613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        StringBuilder sb = new StringBuilder();
        if(str.contains("_")) {
            String[] arr = str.split("_");
            for(int i = 0; i < arr.length; i++) {
                if(i == 0) sb.append(arr[i]);
                else {
                    sb.append(arr[i].substring(0,1).toUpperCase()).append(arr[i].substring(1));
                }
            }
        } else {
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    sb.append("_").append(Character.toLowerCase(str.charAt(i)));
                } else sb.append(str.charAt(i));
            }
        }

        System.out.println(sb.toString());
    }
}
