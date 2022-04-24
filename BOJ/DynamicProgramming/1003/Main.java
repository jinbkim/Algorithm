import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int t;
    static int input[];
    static int dp[][];

    static void fibonachci() {
        dp[0][0] = 1;
        dp[1][1] = 1;

        for(int i=2; i<=40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        dp = new int[41][2];
        fibonachci();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int input = Integer.parseInt(br.readLine());
            sb.append(dp[input][0]).append(' ').append(dp[input][1]).append('\n');
        }
        System.out.println(sb.toString());
    }
}