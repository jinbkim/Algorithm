import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++)
            pq.add((long)scoville[i]);
        
        int answer = 0;
        while(pq.size() >= 2) {
            long n1 = pq.poll();
            long n2 = pq.poll();
            if (K <= n1)
                return answer;
            
            answer++;
            pq.add(n1+n2*2);
        }

        if (pq.poll() >= K)
            return answer;

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] scoville1 = {1, 2, 3, 9, 10, 12};
        int[] scoville2 = {1, 1};

        System.out.println(solution.solution(scoville1, 7));
        System.out.println(solution.solution(scoville2, 3));
    }
}