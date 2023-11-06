class Solution {
    public double average(int[] salary) {
        int min=0,max=0,sum=0;
        double avg;
        for(int i=0;i<salary.length;i++)
        {
            if(salary[i]<salary[min])
            {
                min=i;
            }
            if(salary[i]>salary[max])
            {
                max=i;
            }
            sum+=salary[i];
        }
        avg=(double)(sum-salary[min]-salary[max])/(salary.length-2);
        return avg;
        
    }
}