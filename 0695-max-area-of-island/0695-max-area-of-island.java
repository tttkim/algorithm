class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    
    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int area = check(r, c, grid);
                    if (area > answer)
                        answer = area;
                }
            }
        }
        return answer;
    }
    
    public int check(int r, int c, int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        grid[r][c] = 0;
        int area = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length) {
                    if (grid[nr][nc] == 1) {
                        queue.offer(new int[]{nr, nc});
                        grid[nr][nc] = 0;
                        area++;
                    }
                }
            }
        }
        return area;
    }
}