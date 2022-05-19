public class Main704_2 {
    // 메모이제이션
    public static int[] fibo;
    public static int DFS(int n) { // n번째 항
        if(fibo[n] > 0) return fibo[n]; // 시간복잡도 확 줄었다!
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
