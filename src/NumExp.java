/**
 * A representation of a number lerp expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class NumExp implements Expression {

    private double num;

    /**
     * Construct a number expression.
     *
     * @param num the double that is the number
     */
    public NumExp(double num){
        // TODO
        this.num = num;
    }

    @Override
    public ANFExp toANF(){
        // TODO
        ANFVarExp var = new ANFVarExp();
        ANFOp anOp = new ANFConstOp(num);
        return new ANFLetExp(var, anOp, var); // TODO replaced
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        ANFVarExp var = new ANFVarExp();
        ANFOp anOp = new ANFConstOp(num);
        Holder holdVar =new Holder(var);
        //ANFExp

        return new Triple
                <ANFVarExp, ANFOp, Expression>(var,anOp, holdVar);
    }

    @Override
    public String toString(){
        return ""+this.num;
    }
}
