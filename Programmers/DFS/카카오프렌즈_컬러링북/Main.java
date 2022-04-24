class Solution {

    static boolean[][] visit;
    static int maxRow, maxCol, numberOfArea, area, maxSizeOfOneArea;
    static int map[][];
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static void dfs(int i, int j) {
        if (visit[i][j])
            return ;

        area++;
        visit[i][j] = true;

        for(int k=0; k<4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];

            if (ni<0 || maxRow<=ni || nj<0 || maxCol<=nj || map[ni][nj]!=map[i][j])
                continue; 
            
            dfs(ni, nj);
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[m][n];
        maxRow = m;
        maxCol = n;
        numberOfArea = 0;
        maxSizeOfOneArea=0;
        map = picture;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (picture[i][j] != 0 && !visit[i][j]) {
                    area = 0;
                    dfs(i, j);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        Solution solution = new Solution();
        int[] answer = solution.solution(6, 4, picture);

        for(int ans : answer)
            System.out.println(ans);
    }
}
