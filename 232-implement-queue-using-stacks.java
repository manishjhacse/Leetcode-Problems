import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class MyQueue {
    List<Integer> list;

    public MyQueue() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        Collections.reverse(list);
        int ans = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        Collections.reverse(list);
        return ans;
    }

    public int peek() {
        return list.get(0);
    }

    public boolean empty() {
        return list.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */