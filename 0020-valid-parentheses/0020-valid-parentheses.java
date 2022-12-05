class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                switch (c) {
                    case ')':
                        if (stack.peek() == '(')
                            stack.pop();
                        else
                            stack.push(c);
                        break;
                    case '}':
                        if (stack.peek() == '{')
                            stack.pop();
                        else
                            stack.push(c);
                        break;
                    case ']':
                        if (stack.peek() == '[')
                            stack.pop();
                        else
                            stack.push(c);
                        break;
                    default:
                        stack.push(c);
                        break;
                }
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}