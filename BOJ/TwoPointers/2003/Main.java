import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int numArr[];

    static int twoPointers() {
        int pointer1 = 0;
        int pointer2 = 1;
        int sum = numArr[0];
        int result = 0;

        while (true) {
            if (sum == m) {
                result++;
                sum -= numArr[pointer1++];
            }
            else if (sum < m) {
                if (pointer2 == n)
                    break ;
                sum += numArr[pointer2++];
            }
            else if (m < sum)
                sum -= numArr[pointer1++];
        }

        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numArr = new int[n];
        for(int i=0; i<n; i++)
            numArr[i] = Integer.parseInt(st.nextToken());
        
        System.out.println(twoPointers());
    }
}
