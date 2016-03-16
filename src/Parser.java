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
                Errors.error("Too much input.", null);
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

    private static Expression getExpression(){
        // TODO
        if(tokens[pos].equals("(")){
            pos++;
            if (tokens[pos].equals("+")){
                pos++;
                if (tokens.length < pos + 1){
                    Errors.error("No full expression given", null);
                }
                Expression anExp1 = getExpression();
                Expression anExp2 = getExpression();
                if (tokens.length > pos && tokens[pos].equals(")")){
                    pos++;
                    return new AddExp(anExp1, anExp2);
                }else{
                    Errors.error("Not valid Expression", null);
                }
            }else if (tokens[pos].equals("*")){
                pos++;
                Expression anExp1 = getExpression();
                Expression anExp2 = getExpression();
                if (tokens[pos].equals(")")){
                    pos++;
                    return new MulExp(anExp1, anExp2);
                }
            }else if (tokens[pos].equals("/")){
                pos++;
                Expression anExp1 = getExpression();
                Expression anExp2 = getExpression();
                if (tokens[pos].equals(")")){
                    pos++;
                    return new DivExp(anExp1, anExp2);
                }
            }else if (tokens[pos].equals("-") && tokens.length > 4){
                pos++;
                Expression anExp1 = getExpression();
                Expression anExp2 = getExpression();
                if (tokens[pos].equals(")")){
                    pos++;
                    return new SubExp(anExp1, anExp2);
                }
            }else if (tokens[pos].equals("sqrt")){
                pos++;
                Expression anExp1 = getExpression();
                if (tokens[pos].equals(")")){
                    pos++;
                    return new SqrtExp(anExp1);
                }
            }else if (tokens[pos].equals("-") && tokens.length <= 4){
                pos++;
                Expression anExp1 = getExpression();
                if (tokens[pos].equals(")")){
                    pos++;
                    return new NegExp(anExp1);
                }
            }else {
                Errors.error("No any valid operation found", null);
            }
        }
        return new NumExp((Double.parseDouble(tokens[pos++])));
    }
}