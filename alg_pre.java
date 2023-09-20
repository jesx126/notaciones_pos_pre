import java.util.Stack;

public class alg_pre {
    public static String infixToPrefix(String expression) {

        expression = expression.replaceAll("\\s+", "");
        expression = "(" + expression + ")";
        
        Stack<Character> operators = new Stack<>();
        Stack<String> operands = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    char operator = operators.pop();
                    String operand2 = operands.pop();
                    String operand1 = operands.pop();
                    String result = operator + operand1 + operand2;
                    operands.push(result);
                }
                operators.pop();
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && precedence(ch) <= precedence(operators.peek())) {
                    char operator = operators.pop();
                    String operand2 = operands.pop();
                    String operand1 = operands.pop();
                    String result = operator + operand1 + operand2;
                    operands.push(result);
                }
                operators.push(ch);
            } else {
                
                StringBuilder operand = new StringBuilder();
                while (i < expression.length() && (Character.isLetterOrDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    operand.append(expression.charAt(i));
                    i++;
                }
                i--; 
                operands.push(operand.toString());
            }
        }
        
        return operands.pop();
    }
    
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    
    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }
    
}
