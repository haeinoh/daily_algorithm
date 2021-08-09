import java.util.*;

public class Solution42890 {
    static ArrayList<HashSet<Integer>> list;
    static void solve(int limit, String[][] relation, int count, HashSet<Integer> set) {
        if(count == limit) {

            return;
        }

        for(int i = 0; i < relation.length; i++) {

            solve(limit, relation, count+1, set);
        }

    }
    static int solution(String[][] relation) {
        int answer = 0;
        list = new ArrayList<>();

        for(int i = 0; i < relation[0].length; i++) {
            solve(i, relation, 0, new HashSet<>());
        }

        return answer;
    }
    public static void main(String[] args) {
        String[][] r = {
                {"100","ryan","music","2"},{"200","apeach","math","2"},
                {"300","tube","computer","3"},{"400","con","computer","4"},
                {"500","muzi","music","3"},{"600","apeach","music","2"}
        };
        System.out.println(solution(r));
    }
}
