import java.util.ArrayList;

/**
 * A class that contains the static methods to parse lerp expressions.
 * 
 * @author Arthur Nunes-Harwitt
 */

public class Parser {

    private static int pos;
    private static String[] tokens;


    /**
     * Build a data structure representation of the lerp expression
     * written as a string.
     * 
     * @param s a String that contains the text of a lerp expression
     * @return an Expression data structure representing the lerp expression
     */
    public static Expression parse(String s){
        tokens = s.replace("(", " ( ").replace(")", " ) ").trim().split("( )+");
        pos = 0;
        try{
            Expression e = getExpression();
            if (pos < tokens.length){
                Errors.error(
                        "Too much input.", null);
            } else {
                return e;
            }
        } catch (NumberFormatException e) {
            Errors.error("Expression must start with a number or open parenthesis.", null);
        } catch (Exception e) {
            Errors.error("Unexpected error ", e);
        }
        return null; // Shouldn't get here. To satisfy Java.
    }


    // TODO any other helper methods
    private static Expression grabExpression(String operator){
        pos++;
        Expression anExp1 = getExpression();
        Expression anExp2 = getExpression();
        if (tokens.length < pos+1){
            Errors.error("Expected", "(");
        }
        if (tokens[pos].equals(")")){
            pos++;
            switch (operator){
                case "ADD":
                    return new AddExp(anExp1, anExp2);
                case "MUL":
                    return new MulExp(anExp1, anExp2);
                case "DIV":
                    return new DivExp(anExp1, anExp2);
                default:
                    Errors.error("Not an operator!!!", null);
            }
        }else{
            String message = "Unexpected token: " + tokens[pos] + "; " +
                    "expected ).";
            Errors.error(message, null);
        }
        return null; // shouldn't get here
    }

    private static Expression negSubExp(){
        Expression anExp1 = getExpression();
        if (tokens.length < pos+1){
            Errors.error("Expected", "(");
        }
        if (tokens[pos].equals(")") ){
            pos++;
            return new NegExp(anExp1);
        }
        Expression anExp2 = getExpression();
        if (tokens.length < pos+1){
            Errors.error("Expected", "(");
        }
        if (tokens[pos].equals(")")) {
            pos++;
            return new SubExp(anExp1, anExp2);
        }
        return null; // Error message?
    }

    private static Expression getExpression(){
        if (tokens.length < pos+1){
            Errors.error("Unexpected end of input.", null);
        }
        String theToken = tokens[pos];
        if(theToken.equals("(") && tokens.length > pos+1){
            pos++;
            String token = tokens[pos];
            switch (token){
                case "+":
                    return grabExpression("ADD");
                case "-":   // could be sub or neg
                    pos++;
                    return negSubExp();
                case "*":
                    return grabExpression("MUL");
                case "/":
                    return grabExpression("DIV");
                case "sqrt":
                    pos++;
                    Expression anExp1 = getExpression();
                    if (tokens[pos].equals(")")){
                        pos++;
                        return new SqrtExp(anExp1);
                    }else{
                        String msg="Unexpected token: " + tokens[pos] + "; " +
                                "expected ).";
                        Errors.error(msg, null);
                    }
                default:
                    String info="Unexpected operator: \'" + tokens[pos] + "\'.";
                    Errors.error(info, null);
            }
        }
        if (!(theToken.matches("\\d+") || theToken.matches("\\d+\\.\\d+"))){
            Errors.error("Not a valid token", tokens[pos]);
        }
        return new NumExp((Double.parseDouble(tokens[pos++])));
    }
}
