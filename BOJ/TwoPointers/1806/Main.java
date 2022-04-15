import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int numArr[];
    static int INF = 987654321;

    static int twoPointers() {
        int pointer1 = 0;
        int pointer2 = 1;
        int sum = numArr[0];
        int result = INF;
        
        while (true) {
            if (m <= sum) {
                result = Math.min(result, pointer2-pointer1);
                sum -= numArr[pointer1++];
            }
            else{
                if (pointer2 == n)
                    break ;
                sum += numArr[pointer2++];
            }
        }

        if (result == INF)
            result = 0;
        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            numArr[i] = Integer.parseInt(st.nextToken());
        
        System.out.println(twoPointers());
    }
}
