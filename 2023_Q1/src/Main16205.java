import java.util.Scanner;

public class Main16205 {
    public static String makeCamel(String tmp) {
        String answer = "";
        answer += String.valueOf(tmp.charAt(0)).toLowerCase();

        for(int i = 1; i < tmp.length(); i++) {
            if(tmp.charAt(i) == '_') {
                answer += String.valueOf(tmp.charAt(i+1)).toUpperCase();
            } else if(tmp.charAt(i-1) != '_') answer += tmp.charAt(i);
        }

        return answer;
    }

    public static String makeSnake(String tmp) {
        String answer = "";
        tmp = tmp.substring(0, 1).toLowerCase() + tmp.substring(1);

        for(int i = 0; i < tmp.length(); i++) {
            if(tmp.charAt(i) >= 'A' && tmp.charAt(i) <= 'Z') {
                answer += ("_" + String.valueOf(tmp.charAt(i)).toLowerCase());
            } else answer += tmp.charAt(i);
        }

        return answer;
    }

    public static String makePascal(String tmp) {
        if(tmp.contains("_")) {
            tmp = makeCamel(tmp);
        }

       return  tmp.substring(0, 1).toUpperCase() + tmp.substring(1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(makeCamel(str));
        System.out.println(makeSnake(str));
        System.out.println(makePascal(str));
    }
}
