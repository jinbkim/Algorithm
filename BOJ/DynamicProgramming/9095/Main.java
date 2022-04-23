import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int dp[] = new int [12];

    static void solve() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=11; i++)
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        solve();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int input = Integer.parseInt(br.readLine());
            sb.append(dp[input]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
