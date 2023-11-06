class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high)
        {
            int mid_index=low+(high-low)/2;
            int row=mid_index/m;
            int col=mid_index%m;
            int mid_element=matrix[row][col];
            if(mid_element==target)
            {
                return true;
            }
            else if(mid_element<target)
            {
                low=mid_index+1;
            }
            else{
                high=mid_index-1;
            }
        }
        return false;
    }
}