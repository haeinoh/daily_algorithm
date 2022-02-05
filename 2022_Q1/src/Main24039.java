import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main24039 {
    public static int N;
    public static boolean[] vtd;
    public static void init() {
        vtd[0] = vtd[1] = true;
        for(int i = 2; i <= Math.sqrt(11000); i++) {
            for(int j = i; (i * j) <= Math.sqrt(11000); j++) {
                vtd[i*j] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        N = Integer.parseInt(st.nextToken());

        vtd = new boolean[110];

        init();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i < vtd.length; i++) {
            if(!vtd[i]) list.add(i);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < list.size() - 1; i++) {
            set.add(list.get(i)*list.get(i+1));
        }

        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        int answer = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > N) {
                answer = i;
                break;
            }
        }
        System.out.println(arr[answer]);
    }
}
