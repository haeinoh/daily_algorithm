import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1339 {
    public static int N, answer;
    public static int[] arr, word;
    public static boolean[] vtd;
    public static HashSet<Character> set; // 중복 단어 거르기
    public static ArrayList<String> list; // 계산해아할 단어들
    public static void solve() {
        int calc = 0;

        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            int num = 0;
            for(int j = 0; j < str.length(); j++) {
                num *= 10;
                num += arr[str.charAt(j)-65];
            }
            calc += num;
        }

        answer = Math.max(answer, calc);
    }

    public static void comb(int cnt) {
        if(cnt == set.size()) {
            solve();
            return;
        }

        for(int i = 9; i >= 9-word.length+1; i--) {
            if(!vtd[i]) {
                vtd[i] = true;
                arr[word[cnt]] = i;
                comb(cnt+1);
                vtd[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        list = new ArrayList<>();
        answer = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine().trim());
            String str = st.nextToken();
            // 중복 알파벳
            for(int j = 0; j < str.length(); j++) set.add(str.charAt(j));

            list.add(str);
        }

        List<Character> tmp = new ArrayList<>(set);

        word = new int[set.size()]; // 나온 단어들
        arr = new int[27]; // 단어 조합 만들 것
        vtd = new boolean[10];
        for(int i = 0; i < set.size(); i++) {
            word[i] = tmp.get(i) - 65;
        }

        comb(0);

        System.out.println(answer);
    }
}
