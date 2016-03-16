/**
 * A representation of the square root lerp expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class SqrtExp extends UnaryExp {

    /**
     * Construct a square root expression.
     *
     * @param exp the Expression that is the first operand of the
     * square root expression
     */
    public SqrtExp(Expression exp){
        // TODO
        super(exp);
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        // TODO

        Expression anExp = getExp();
        if (anExp instanceof  Holder){
            ANFVarExp var = new ANFVarExp();
            ANFVarExp newVar = ((Holder) anExp).getVar();
            ANFOp anOp = new ANFSqrtOp(newVar);
            return new Triple<>(var,anOp, new Holder(var));
        }
        Triple <ANFVarExp, ANFOp, Expression> newTriple = anExp.extract();
        return new Triple<>(newTriple.first(), newTriple.second(), new
                SqrtExp(newTriple.third()) );
    }

    @Override
    public String toString(){
        return "(sqrt " + super.toString() + ")";
    }
}
