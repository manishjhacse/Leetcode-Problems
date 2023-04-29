class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int C[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(A[i]==B[i])
            {
                count++;
            }
            else{
            for(int j=0;j<=i;j++)
            {
                if(A[i]==B[j])
                {
                    count++;
                }
                if(B[i]==A[j])
                {
                    count++;
                }
            }
        }
            C[i]=count;
        }
        return C;
    }
}