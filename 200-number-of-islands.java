class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        boolean [][] visited = new boolean [grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j])  continue;
                if(grid[i][j] == '1'){
                    ans++;
                    
                    destroyLand(grid, i, j, visited);
                }
            }
        }
        return ans;
    }

    void destroyLand(char[][] grid , int i, int j, boolean [][] visited){
        if(visited[i][j])   return ;
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length){
            grid[i][j] = '0';
            visited[i][j] = true;
            
            if(i>0 && i<grid.length && grid[i-1][j] == '1')  destroyLand(grid, i-1, j, visited);
            if(i>=0 && i<grid.length-1 && grid[i+1][j] == '1')  destroyLand(grid, i+1, j, visited);
            if(j>0 && j<grid[0].length && grid[i][j-1] == '1')  destroyLand(grid, i, j-1, visited);
            if(j>=0 && j<grid[0].length-1 && grid[i][j+1] == '1')  destroyLand(grid, i, j+1, visited);
            
        }
    }
}