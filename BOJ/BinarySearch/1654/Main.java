import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static long widthMax = 0;
    static long k, n, lines[];

    static boolean isPossible(long width) {
        if (width <= 0)
            return true;
        
        long sum = 0;
        for(int i=0; i<k; i++)
            sum += lines[i]/width;
        
        if (n <= sum)
            return true;
        return false;
    }

    static void binarySearch(long start, long end) {
        long mid = (start+end) / 2;

        if (end < start)
            return ;
        if (isPossible(mid)) {
            if (widthMax < mid)
                widthMax = mid;
            binarySearch(mid+1, end);
        }
        else
            binarySearch(start, mid-1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        lines = new long[(int)k];
        for(int i=0; i<k; i++)
            lines[i] = sc.nextInt();
        
        Arrays.sort(lines);
        binarySearch(0, lines[(int)k-1]);
        System.out.println(widthMax);
    }
}
