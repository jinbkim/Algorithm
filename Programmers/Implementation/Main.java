class Solution {
    static int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        int n = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++)
                map[i][j] = ++n;
        }
        int[] answer = new int[queries.length];

        for(int i=0; i<queries.length; i++) {
            int sourceY = queries[i][0]-1;
            int sourceX = queries[i][1]-1;
            int destinationY = queries[i][2]-1;
            int destinationX = queries[i][3]-1;
            int temp = map[sourceY][sourceX];
            int min = temp;

            for(int j=sourceY; j<destinationY; j++) {
                map[j][sourceX] = map[j+1][sourceX];
                min = Math.min(min, map[j][sourceX]);
            }
            for(int j=sourceX; j<destinationX; j++) {
                map[destinationY][j] = map[destinationY][j+1];
                min = Math.min(min, map[destinationY][j]);
            }
            for(int j=destinationY; sourceY<j; j--) {
                map[j][destinationX] = map[j-1][destinationX];
                min = Math.min(min, map[j][destinationX]);
            }
            for(int j=destinationX; sourceX<j; j--) {
                map[sourceY][j] = map[sourceY][j-1];
                min = Math.min(min, map[sourceY][j]);
            }

            map[sourceY][sourceX+1] = temp;
            answer[i] = min;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int rows[] = {6, 3, 100};
        int columns[] = {6, 3, 97};
        int queries[][][] = {{{2,2,5,4},{3,3,6,6},{5,1,6,3}}, {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}}, {{1,1,100,97}}};

        for(int i=0; i<3; i++) {
            int[] result = solution.solution(rows[i], columns[i], queries[i]);
            for(int j=0; j<result.length; j++)
                System.out.print(result[j] + " ");
            System.out.println();
        }
    }
}