package interview_bytedance.round11;

import java.util.Stack;

public class Problem01 {


    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public Problem01() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (x < min) {
            min = x;
        }

        stack.push(x);
    }

    public void pop() {
        int top = stack.pop();
        if (top != min) {
            return;
        }

        // update min
        int newMin = Integer.MAX_VALUE;
        for (Integer num : stack) {
            if (num < newMin) {
                newMin = num;
            }
        }

        min = newMin;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    
    public static void main(String[] args) {

    }
    
}
