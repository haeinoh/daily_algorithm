public class Main704_1 {
    // 배열 + DFS
    public static int[] fibo;
    public static int DFS(int n) { // n번째 항 
        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 2;
        else return fibo[n] = DFS(n-2) + DFS(n-1);
    }

    public static void main(String[] args) {
        int n = 10;
        fibo = new int[n+1];
        System.out.println(DFS(n));
    }
}
