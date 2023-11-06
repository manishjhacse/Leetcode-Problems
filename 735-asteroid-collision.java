import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<asteroids.length;i++)
        {

            if(stack.isEmpty() || asteroids[i]>0)
            {
                stack.push(asteroids[i]);
            }
            else if(asteroids[i]<0)
            {
                while(!stack.isEmpty()){
                    int top=stack.peek();
                    if(top<0)
                    {
                        stack.push(asteroids[i]);
                        break;
                    }
                    int modValue=Math.abs(asteroids[i]);
                    if(modValue==top)
                    {
                        stack.pop();
                        break;
                    }
                    else if(modValue<top)
                    {
                        break;
                    }
                    else{
                        stack.pop();
                        if(stack.isEmpty())
                        {
                            stack.push(asteroids[i]);
                            break;
                        }
                    }


                }
            }
        }
        int size=stack.size();
        int ans[]=new int[size];
        for(int i=size-1;i>=0;i--)
        {
            ans[i]=stack.pop();
        }
        return ans;
    }
}