class Solution {

    static long findCommonDivisor(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return findCommonDivisor(n2, n1%n2);
    }

    public long solution(int w, int h) {
        long commonDivisor = findCommonDivisor(w, h);
        long reducedW = w/commonDivisor;
        long reducedH = h/commonDivisor;

        return (long)w*(long)h-(commonDivisor)*(reducedW+reducedH-1);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 12));
    }
}
