import java.util.*;

public class Converter {
    private String infix;

    public Converter(String infix) {
        this.infix = infix;
    }

    private static int GetOperatorWeight(String op) {
        int weight = 0;
        switch (op) {
            case "+":
            case "-":
                weight = 1;
                break;
            case "*":
            case "/":
                weight = 2;
                break;
            case "^":
                weight = 3;
                break;
        }
        return weight;
    }

    private static boolean HasHigherPrecedence(String op1, String op2) {
        int op1Weight = GetOperatorWeight(op1);
        int op2Weight = GetOperatorWeight(op2);

        return op1Weight > op2Weight;
    }

    public String toPostFix() {
        List<String> infixTokens = ParserHelper.parse(infix.toCharArray());
        ArrayStack<String> stack = new ArrayStack<>();
        String postfix = "";
        for (String token : infixTokens) {
            if (Character.isDigit(token.charAt(0))) {
                postfix = postfix + token + " ";
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.top().equals("(")) {
                    postfix = postfix + stack.pop() + " ";
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && !HasHigherPrecedence(token, stack.top())) {
                    postfix = postfix + stack.pop() + " ";
                }
                stack.push(token);
            }
        }
        while (!stack.isEmpty()) {
            postfix = postfix + stack.pop() + " ";
        }
        return postfix;
    }
}