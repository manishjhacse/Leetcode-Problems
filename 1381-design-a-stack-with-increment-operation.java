class CustomStack {
    int index;
    int stack[];
    int size;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        index = -1;
        size = maxSize;
    }

    public void push(int x) {
        if (index < size - 1) {
            index++;
            stack[index] = x;
        }
    }

    public int pop() {
        if (index >= 0) {
            int element = stack[index];
            index--;
            return element;
        } else {
            return -1;
        }
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k; i++) {
            if (i > index)
                break;
            stack[i] += val;
        }

    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */