/**
 * An abstract class to characterize the common data and methods
 * associated with unary expressions.
 *
 * @author Arthur Nunes-Harwitt
 */
public abstract class UnaryExp implements Expression {

    private Expression exp;

    
    /**
     * Initialize the operand.  This constructor can only be
     * invoked by a sub-class.
     *
     * @param exp the Expression that is the operand of the
     * unary expression
     */
    public UnaryExp(Expression exp){
        // TODO
        this.exp = exp;
    }

    /**
     * A selector for getting the operand from a unary expression.
     *
     * @return the Expression that is the operand of the unary expression
     */
    public Expression getExp(){
        // TODO
        return exp; // TODO replaced
    }

    @Override
    public ANFExp toANF(){
        // TODO
        Triple<ANFVarExp, ANFOp, Expression> myTriple = extract();
        ANFVarExp var = myTriple.first();
        ANFOp anOp = myTriple.second();
        Expression holdVar = myTriple.third();
        return new ANFLetExp(var, anOp, holdVar.toANF());
    }

    @Override
    public abstract Triple<ANFVarExp, ANFOp, Expression> extract();

    @Override
    public String toString(){
        return this.exp.toString();
    }
}
