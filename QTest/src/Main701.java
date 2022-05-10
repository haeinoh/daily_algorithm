public class Main701 {
    public static void DFS(int n) {
        if(n == 0) return;
        else{
            System.out.println(n); // 3, 2, 1
            DFS(n-1);
            System.out.println(n); // 1, 2, 3
        }
    }
    public static void main(String[] args) {
        Main701 T = new Main701();
        T.DFS(3);
    }
}
