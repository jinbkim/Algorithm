import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int i=0;
        while (i < progresses.length) {
            for(int j=i; j<progresses.length; j++)
                progresses[j] += speeds[j];

            int count = 0;
            while (i<progresses.length && 100<=progresses[i]) {
                i++;
                count++;
            }

            if (0 < count)
                list.add(count);
        }
        
        return list.stream().mapToInt(l->l).toArray();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] progresses = {{93, 30, 55}, {95, 90, 99, 99, 80, 99}};
        int[][] speeds = {{1, 30, 5}, {1, 1, 1, 1, 1, 1}};

        int result1[] = solution.solution(progresses[0], speeds[0]);
        int result2[] = solution.solution(progresses[1], speeds[1]);

        for(int i=0; i<result1.length; i++)
            System.out.print(result1[i] + " ");
        System.out.println();
        for(int i=0; i<result2.length; i++)
            System.out.print(result2[i] + " ");
    }
}