public class PostfixCalculator {

    public static double evaluate(String postfix) {
        ArrayStack<Double> stack = new ArrayStack<>();
        String[] tokens = postfix.split(" ");
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Double.valueOf(token));
            } else {
                double op2 = stack.pop();
                double op1 = stack.pop();
                switch (token) {
                    case "+": 
                        stack.push(op1 + op2); 
                        break;
                    case "-": 
                        stack.push(op1 - op2); 
                        break;
                    case "*": 
                        stack.push(op1 * op2); 
                        break;
                    case "/": 
                        stack.push(op1 / op2); 
                        break;
                    case "^": 
                        stack.push(Math.pow(op1, op2)); 
                        break; 
                }
            }
        }
        return stack.pop();
    }
    
}
