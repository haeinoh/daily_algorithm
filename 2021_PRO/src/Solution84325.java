public class Solution84325 {
    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int compare = 0;

        for(int i = 0; i < table.length; i++) {
            String[] tmp = table[i].split(" ");
            int cal = 0;
            for(int k = 0; k < languages.length; k++) {
                for(int p = 1; p < tmp.length; p++) {
                    if(languages[k].equals(tmp[p])) {
                        cal += (tmp.length - p) * preference[k];
                        break;
                    }
                }
            }
            if(compare < cal) {
                answer = tmp[0];
                compare = cal;
            } else if(compare == cal) {
                if(answer.compareTo(tmp[0]) > 0) answer = tmp[0];
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] t = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] l = {"PYTHON", "C++", "SQL"};
        int[] p = {7, 5, 5};
        System.out.println(solution(t, l, p));
    }
}
