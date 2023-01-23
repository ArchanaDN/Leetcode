import java.util.*;

public class PostFix {

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i] == "+" || tokens[i] == "-"|| tokens[i] == "*" || tokens[i] == "/") {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int num3;
                if(tokens[i] == "+") {
                    num3 = num1 + num2;
                } else if(tokens[i] == "-") {
                    num3 = num2 - num1;
                } else if(tokens[i] == "*") {
                    num3 = num1 * num2;
                } else {
                    num3 = num2 / num1;
                }
                stack.push(num3);
                res = num3;
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return res;
        
    }
    
}
