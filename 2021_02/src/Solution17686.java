import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution17686 {
    public static ArrayList<File> list;
    static class File implements Comparable<File>{
        int idx;
        String head;
        int number;

        public File(int idx, String head, int number) {
            this.idx = idx;
            this.head = head;
            this.number = number;
        }

        @Override
        public int compareTo(File file) {
            if(this.head.equals(file.head)) {
                if(this.number == file.number) return this.idx - file.idx;
                return this.number - file.number;
            }

            return this.head.compareTo(file.head);
        }
    }
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        list = new ArrayList<>();
        for(int i  = 0; i < files.length; i++) {
            boolean flag = false;
            boolean numFlag = false;
            String head = "";
            String num = "";
            for(int j = 0; j < files[i].length(); j++) {
                if(flag && !(0 <= Character.getNumericValue(files[i].charAt(j)) && Character.getNumericValue(files[i].charAt(j)) <= 9)) {
                    numFlag = true;
                } else if(!numFlag && (0 <= Character.getNumericValue(files[i].charAt(j)) && Character.getNumericValue(files[i].charAt(j)) <= 9)) {
                    num += files[i].charAt(j);
                    flag = true;
                } else if(!flag){
                    head += files[i].charAt(j);
                }
            }
            list.add(new File(i, head.toLowerCase(), Integer.parseInt(num)));
        }
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            answer[i] = files[list.get(i).idx];
        }

        return answer;
    }

    public static void main(String[] args) {
        String s[] = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(s)));
    }
}
