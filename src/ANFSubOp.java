
/**
 * A representation of the subtraction operation for ANF-expressions.
 *
 * @author Arthur Nunes-Harwitt
 */
public class ANFSubOp extends ANFBinOp {

    /**
     * Construct an ANF subtraction operation.
     *
     * @param x1 the ANFVarExp that is the first operand of the
     * subtraction operation
     * @param x2 the ANFVarExp that is the second operand of the
     * subtraction operation
     */
    public ANFSubOp(ANFVarExp x1, ANFVarExp x2){
        // TODO
        super(x1, x2);
    }

    @Override
    public void compile(int dest, Machine m){
        // TODO
        m.addSub(dest, getX1().getN(), getX2().getN());
    }

    @Override
    public String toString(){
        return "(- " + super.toString() + ")";
    }
}
