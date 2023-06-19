//Problem: https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1

class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        char ch,temp;
        String result = "";
        Stack<Character> stc = new Stack<>();
        for(int i=0 ;i<exp.length(); i++) {
            ch = exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)) {
                result += ch;
            } else if(ch == ')') {
                while(!stc.isEmpty()) {
                    temp = stc.pop();
                    if(temp == '(') {
                        break;
                    }
                    result += temp;
                }
            } else if(ch=='(' || stc.isEmpty() || precedence(stc.peek())<precedence(ch)){
                stc.push(ch);
            } else {
                while(!stc.isEmpty() && precedence(stc.peek())>=precedence(ch) ) {
                    result += stc.pop();
                }
                stc.push(ch);
            }
        }
        
        while(!stc.isEmpty()) {
            result += stc.pop();
        }
        
        return result;
    }
    
    public static int precedence(char c) {
        switch(c) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
        }
        
        return 0;
    }
}
