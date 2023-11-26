class Solution {
    public int calPoints(String[] op) {
        ArrayList<Integer> a=new ArrayList<>();
        int sum=0;
        for(int i=0;i<op.length;i++)
        {
            if(Character.isDigit(op[i].charAt(0)))
            {
                a.add(Integer.parseInt(op[i]));
            }
            else if(op[i].charAt(0)=='-')
            {
                a.add(Integer.parseInt(op[i]));
            }
            else if(op[i].equals("D"))
            {
                a.add(a.get(a.size()-1)*2);                
            }
            else if(op[i].equals("C"))
            {
                a.remove(a.size()-1);
            }
            else if(op[i].equals("+"))
            {
                a.add(a.get(a.size()-1)+a.get(a.size()-2));
            }        
        }
        for(int i:a)
        {
            sum+=i;
        }
        return sum;
    }
}