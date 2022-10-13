import java.util.Scanner;

public class Main4659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = sc.next();
            if(str.equals("end")) break;

            sb.append("<").append(str).append("> is ");
            boolean flag = false;
            if(!str.contains("a") && !str.contains("e") && !str.contains("i") && !str.contains("o") && !str.contains("u")) flag = true;
            else {
                for(int i = 0; i < str.length() - 1; i++) {
                    if(str.charAt(i) == str.charAt(i+1) && (str.charAt(i) != 'e' && str.charAt(i) != 'o')) {
                        flag = true;
                        break;
                    }
                }
                int vowel = 0;
                int cons = 0;
                for(int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                        cons = 0;
                        vowel++;
                    } else {
                        vowel = 0;
                        cons++;
                    }
                    if(vowel >= 3 || cons >= 3) {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) sb.append("not acceptable.");
            else sb.append("acceptable.");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
