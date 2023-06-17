//Problem: https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1

class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0 ;i<S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isDigit(c)) {
                stack.push(c-'0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch(c) {
                    case '+':
                        stack.push(val1+val2);
                        break;
                    case '-':
                        stack.push(val2-val1);
                        break;
                    case '*':
                        stack.push(val1*val2);
                        break;
                    case '/':
                        stack.push(val2/val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}