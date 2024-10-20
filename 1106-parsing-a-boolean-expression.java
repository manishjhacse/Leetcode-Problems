class Solution {
    public boolean parseBoolExpr(String expression) {
        return evaluate(expression);
    }

    private boolean evaluate(String expr) {
        char first = expr.charAt(0);
        
        if (first == 't') return true;
        if (first == 'f') return false;
        
        if (first == '!') {
            return !evaluate(expr.substring(2, expr.length() - 1));
        }
        
        if (first == '&') {
            return andOperation(expr.substring(2, expr.length() - 1));
        }
        
        if (first == '|') {
            return orOperation(expr.substring(2, expr.length() - 1));
        }
        
        return false;
    }

    private boolean andOperation(String expr) {
        boolean result = true;
        int balance = 0;
        StringBuilder currentExpr = new StringBuilder();
        
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(') balance++;
            if (ch == ')') balance--;
            
            if (ch == ',' && balance == 0) {
                result = result && evaluate(currentExpr.toString());
                currentExpr.setLength(0);
            } else {
                currentExpr.append(ch);
            }
        }
        
        if (currentExpr.length() > 0) {
            result = result && evaluate(currentExpr.toString());
        }
        
        return result;
    }
    
    private boolean orOperation(String expr) {
        boolean result = false;
        int balance = 0;
        StringBuilder currentExpr = new StringBuilder();
        
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(') balance++;
            if (ch == ')') balance--;
            
            if (ch == ',' && balance == 0) {
                 result = result || evaluate(currentExpr.toString());
                currentExpr.setLength(0); 
            } else {
                currentExpr.append(ch);
            }
        }
        
        if (currentExpr.length() > 0) {
            result = result || evaluate(currentExpr.toString());
        }
        
        return result;
    }
    
   
}