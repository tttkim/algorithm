class MyQueue {
    ArrayDeque<Integer> store;
    ArrayDeque<Integer> forPop;
    public MyQueue() {
        store = new ArrayDeque<>();
        forPop = new ArrayDeque<>();
    }
    
    public void push(int x) {
        while (!forPop.isEmpty()) {
            store.push(forPop.pop());
        }
        store.push(x);
    }
    
    public int pop() {
        while (!store.isEmpty()) {
            forPop.push(store.pop());
        }
        return forPop.pop();
    }
    
    public int peek() {
        while (!store.isEmpty()) {
            forPop.push(store.pop());
        }
        return forPop.peek();
    }
    
    public boolean empty() {
        if (forPop.isEmpty() && store.isEmpty())
            return true;
        return false;
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