import java.util.Stack;

public class _232_ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param_2 = obj.peek();
        int param_3 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    static class MyQueue {
        private static Stack<Integer> inStack;
        private static Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                inToOut();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                inToOut();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void inToOut() {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
