import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int waitTimes[] = new int[n];
        for(int i=0; i<n; i++)
            waitTimes[i] = sc.nextInt();

        Arrays.sort(waitTimes);
        int result = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<n-i; j++)
                result += waitTimes[j];
        
        System.out.println(result);
    }
}
