/**
 * A representation of the division lerp expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class DivExp extends BinaryExp {

    /**
     * Construct an division expression.
     *
     * @param exp1 the Expression that is the first operand of the
     * division expression
     * @param exp2 the Expression that is the second operand of the
     * division expression
     */
    public DivExp(Expression exp1, Expression exp2){
        // TODO
        super(exp1, exp2);
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){

        Expression anExp1 = getExp1();
        Expression anExp2 = getExp2();

        if (anExp1 instanceof  Holder && anExp2 instanceof Holder){
            ANFVarExp var = new ANFVarExp();
            ANFVarExp newVar1 = ((Holder) anExp1).getVar();
            ANFVarExp newVar2 = ((Holder) anExp2).getVar();
            ANFOp anOp = new ANFDivOp(newVar1, newVar2);
            return new Triple<>(var,anOp, new Holder(var));
        } else if (!(anExp1 instanceof Holder)) {
            Triple<ANFVarExp, ANFOp, Expression> newTriple1 = anExp1.extract();
            return new Triple<>(newTriple1.first(), newTriple1.second(), new
                    DivExp(newTriple1.third(), anExp2));
        } else {

            Triple<ANFVarExp, ANFOp, Expression> newTriple2 = anExp2.extract();


            return new Triple<>(newTriple2.first(), newTriple2.second(), new DivExp
                    (newTriple2.third(), anExp1));
        }
    }

    @Override
    public String toString(){
        return "(/ " + super.toString() + ")";
    }
}
