import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[] numArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        numArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            numArr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numArr, 0, n);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<m; i++) {
            if(Arrays.binarySearch(numArr, Integer.parseInt(st.nextToken())) >= 0)
                sb.append(1).append('\n');
            else
                sb.append(0).append('\n');
        }
        
        System.out.println(sb.toString());
    }
}
