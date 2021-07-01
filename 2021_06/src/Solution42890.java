import java.util.HashSet;

public class Solution42890 {
    public static int solution(String[][] relation) {
        int answer = 0;
        loop:for(int i = 0; i < relation.length; i++) {
            HashSet<String> set = new HashSet<>();
            boolean flag = false;
            for(int j = 0; j < relation[i].length; j++) {
                if(set.contains(relation[j][i])) {
                    flag = true;
                    break;
                }
                set.add(relation[i][j]);
            }
            if(!flag) {
                answer++;
                continue loop;
            }

        }
        return answer;
    }
    public static void main(String[] args) {
        String[][] r = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"},
                    {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"},
                    {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};

        System.out.println(solution(r));
    }
}
