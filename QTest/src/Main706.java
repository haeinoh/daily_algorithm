public class Main706 {
    static int n;
    static int[] ch;
    public static void DFS(int L) {
        if(L == n+1) { // depth
            String tmp = "";
            for(int i = 0; i <= n; i++) {
                if(ch[i] == 1) tmp += (i + "");
            }
            if(tmp.length() > 0) System.out.println(tmp);
        } else {
            ch[L] = 1;
            DFS(L+1); // 왼쪽 (사용함 O)
            ch[L] = 0;
            DFS(L+1); // 오른쪽 (사용하지 않음X)
        }
    }

    public static void main(String[] args) {
        n = 3;
        ch = new int[n+1];
        DFS(1);
    }
}
