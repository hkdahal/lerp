/**
 * A representation of the negation lerp expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class NegExp extends UnaryExp {

    /**
     * Construct a negation expression.
     *
     * @param exp the Expression that is the first operand of the
     * negation expression
     */
    public NegExp(Expression exp){
        // TODO
        super(exp);
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){

        Expression holdVar = getExp();
        if (holdVar instanceof  Holder){
            ANFVarExp var = new ANFVarExp();
            ANFVarExp newVar = ((Holder) holdVar).getVar();
            ANFOp anOp = new ANFNegOp(newVar);
            return new Triple<>(var,anOp, new Holder(var));
        }
        Triple <ANFVarExp, ANFOp, Expression> newTriple = holdVar.extract();
        return new Triple<>(newTriple.first(), newTriple.second(), new
                NegExp(newTriple.third()) );
    }

    @Override
    public String toString(){
        return "(- " + super.toString() + ")";
    }
}
