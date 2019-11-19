package com.zk.offer66.from61to66;

/**
 * 机器人的运动范围
 */
public class Q66MovingCount {
    int[][] move = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    /**
     * 解法1 明显2更好
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        int result = 0;
        visited[0][0] = true;
        dfs(0, 0, threshold, visited, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(int x, int y, int threshold, boolean[][] visited, int rows, int cols) {
        for (int i = 0; i < move.length; i++) {
            int xx = x + move[i][0];
            int yy = y + move[i][1];
            if (xx < 0 || xx >= rows || yy < 0 || yy >= cols) {
                continue;
            }
            if (!visited[xx][yy] && calculateSum(xx, yy) <= threshold) {
                visited[xx][yy] = true;
                dfs(xx, yy, threshold, visited, rows, cols);
            }
        }
    }

    public int calculateSum(int x, int y) {
        int sum = 0;
        while (x > 0) {
            sum += (x % 10);
            x = x / 10;
        }
        while (y > 0) {
            sum += (y % 10);
            y = y / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q66MovingCount q66 = new Q66MovingCount();
        System.out.println(q66.movingCount3(15, 1, 1));
    }


    public int movingCount2(int threshold, int rows, int cols) {
        if (threshold < 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        return dfs2(rows,cols,threshold,visited,0,0);
    }

    /**
     *和65题矩阵中的路径相比，这题的特点是每个格子主要访问一次
     */
    public int dfs2(int rows, int cols, int threshold, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y]) {
            return 0;
        }
        if (calculateSum(x, y) <= threshold) {
            visited[x][y] = true;
            return 1 + dfs2(rows,cols,threshold,visited,x+1,y)+dfs2(rows,cols,threshold,visited,x-1,y)+
                    dfs2(rows,cols,threshold,visited,x,y+1)+dfs2(rows,cols,threshold,visited,x,y-1);
        } else {
            return 0;
        }
    }
    int res = 0;
    public int movingCount3(int threshold, int rows, int cols)
    {
        res = 0;
        boolean[][] visited = new boolean[rows][cols];
        dfs(threshold,rows,cols,0,0,visited);
        return res;
    }
    public void dfs(int threshold, int rows, int cols,int x,int y,boolean[][] visited){
        if(x < 0 || x >= rows|| y < 0 || y >= cols || visited[x][y]){
            return;
        }
        if((cal(x)+cal(y)) <= threshold){
            visited[x][y] = true;
            res++;
            dfs(threshold,rows,cols,x-1,y,visited);
            dfs(threshold,rows,cols,x+1,y,visited);
            dfs(threshold,rows,cols,x,y-1,visited);
            dfs(threshold,rows,cols,x,y+1,visited);
        }else{
            visited[x][y] = true;
            return;
        }
    }
    private int cal(int num){
        int temp = 0 ;
        while(num >0){
            temp = temp + num % 10;
            num = num/10;
        }
        return temp;
    }
}
