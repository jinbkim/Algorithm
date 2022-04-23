import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int home[][] = new int[n+1][3];
        int dp[][] = new int [n+1][3];
        StringTokenizer st;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            home[i][0] = Integer.parseInt(st.nextToken());
            home[i][1] = Integer.parseInt(st.nextToken());
            home[i][2] = Integer.parseInt(st.nextToken());
            
            dp[i][0] = Math.min(dp[i-1][1]+home[i][0], dp[i-1][2]+home[i][0]);
            dp[i][1] = Math.min(dp[i-1][2]+home[i][1], dp[i-1][0]+home[i][1]);
            dp[i][2] = Math.min(dp[i-1][0]+home[i][2], dp[i-1][1]+home[i][2]);
        }
        
        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}
