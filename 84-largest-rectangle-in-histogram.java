import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        // int n = heights.length;
        // int maxArea = 0;
        // Stack<Integer> st = new Stack<>();
        // int leftSmall[] = new int[n];
        // int rightSmall[] = new int[n];
        // for (int i = 0; i < n; i++) {
        //     while (!st.empty() && heights[st.peek()] >= heights[i]) {
        //         st.pop();
        //     }
        //     if (st.empty()) {
        //         leftSmall[i] = 0;
        //     } else {
        //         leftSmall[i] = st.peek() + 1;
        //     }
        //     st.push(i);
        // }
        // while (!st.empty()) {
        //     st.pop();
        // }
        // for (int i = n - 1; i >= 0; i--) {
        //     while (!st.empty() && heights[st.peek()] >= heights[i]) {
        //         st.pop();
        //     }
        //     if (st.empty()) {
        //         rightSmall[i] = n - 1;
        //     } else {
        //         rightSmall[i] = st.peek() - 1;
        //     }
        //     st.push(i);
        // }
        // for (int i = 0; i < n; i++) {
        //     int area = (rightSmall[i] - leftSmall[i] + 1) * heights[i];
        //     maxArea = Math.max(maxArea, area);
        // }
        // return maxArea;
        int n=heights.length;
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            while (!stack.empty()&&(i==n || heights[stack.peek()]>=heights[i])) {
              int h=heights[stack.peek()];
              stack.pop();
              int width;
              if(stack.empty()) 
              width=i-0;
              else{
                width=i-stack.peek()-1;
              }  
              maxArea=Math.max(maxArea, width*h);
            }
            stack.push(i);
        }
        return maxArea;
    }
}