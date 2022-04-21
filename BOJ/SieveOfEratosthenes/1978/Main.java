import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean isPrime[];
    static final int maxN = 1000;

    static void checkPrime() {
        for(int i=2; i<=maxN; i++) {
            int j = 1;
            while (true) {
                j++;
                if (i*j > maxN)
                    break ;
                isPrime[i*j] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isPrime = new boolean[maxN+1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        checkPrime();

        n = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(st.nextToken());
            if (isPrime[number] == true)
                answer++;
        }
        System.out.println(answer);

    }
}
