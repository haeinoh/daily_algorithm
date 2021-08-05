import java.util.Arrays;
import java.util.Comparator;

public class Solution42577_2 {

    static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));

        for(int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        String[] p = {"119", "97674223", "1195524421"};
        System.out.println(solution(p));
    }
}
