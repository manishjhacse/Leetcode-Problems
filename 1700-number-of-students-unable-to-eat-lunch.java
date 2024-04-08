class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int prefersCircular=0;
        int prefersSquare=0;
        for(int i=0;i<students.length;i++){
            if(students[i]==0){
                prefersCircular++;
            }else{
                prefersSquare++;
            }
        }
        for(int i=0;i<sandwiches.length;i++){
            if(sandwiches[i]==0 && prefersCircular==0){
                return prefersSquare;
            }else if(sandwiches[i]==1 && prefersSquare==0){
                return prefersCircular;
            }else if(sandwiches[i]==0){
                prefersCircular--;
            }else{
                prefersSquare--;
            }
        }
        return 0;
    }
}