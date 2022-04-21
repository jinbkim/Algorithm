import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int m, n;
    static boolean isPrime[];

    static void findPrime() {
        isPrime[1] = false;
        for(int i=2; i<=Math.sqrt(n); i++) {
            int j = 1;
            while (true) {
                j++;
                if (n < i*j)
                    break ;
                isPrime[i*j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        findPrime();

        StringBuilder sb = new StringBuilder();
        for(int i=m; i<=n; i++) {
            if (isPrime[i] == true)
                sb.append(i).append('\n');
        }
        System.out.println(sb.toString());
    }
}
