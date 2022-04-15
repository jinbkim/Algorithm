import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean isPrime(int n) {
        for(int i=2; i<=Math.sqrt(n); i++) {
            if (n%i == 0)
                return false; 
        }
        return true;
    }

    static int twoPointer(int destination) {
        int pointer1 = 0;
        int pointer2 = 1;
        List<Integer> primeList = new ArrayList<>();

        if (destination == 1)
            return 0;
            
        for(int i=2; i<=destination; i++) {
            if (isPrime(i) == true)
                primeList.add(i);
        }

        int result = 0;
        int sum = primeList.get(0);
        while (true) {
            if (sum == destination) {
                result++;
                sum -= primeList.get(pointer1++);
            }
            else if (sum < destination) {
                if (pointer2 == primeList.size())
                    break;
                sum += primeList.get(pointer2++);
            }
            else
                sum -= primeList.get(pointer1++);
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(twoPointer(n));
    }
}
