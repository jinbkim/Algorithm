import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int dp[];
    static int INF = 987654321;
    static void makeOne() {
        dp[1] = 0;

        for(int i=1; i<n; i++) {
            if (3*i <= n)
                dp[3*i] = Math.min(dp[3*i], dp[i]+1);
            if (2*i <= n)
                dp[2*i] = Math.min(dp[2*i], dp[i]+1);
            dp[i+1] =  Math.min(dp[i+1], dp[i]+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];
        Arrays.fill(dp, INF);
        makeOne();
        System.out.println(dp[n]);
    }
}
