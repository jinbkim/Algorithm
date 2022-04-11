import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[] numArr;
    static boolean isFind;

    static void find(int start, int end, int value) {

        int mid = (start + end) / 2;
        
        if (end < start || isFind == true)
            return ;
        if (numArr[mid] == value) {
            isFind = true;
            return ;
        }

        if (value < numArr[mid])
            find(start, mid-1, value);
        else
            find(mid+1, end, value);
    }
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
            isFind = false;
            find(0, n-1, Integer.parseInt(st.nextToken()));
            if (isFind == true)
                sb.append(1).append('\n');
            else
                sb.append(0).append('\n');
        }
        
        System.out.println(sb.toString());
    }
}
