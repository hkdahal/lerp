
/**
 * A representation of the square root operation for ANF-expressions.
 *
 * @author Arthur Nunes-Harwitt
 */
public class ANFSqrtOp extends ANFUnOp {

    /**
     * Construct an ANF square root operation.
     *
     * @param x the ANFVarExp that is the operand of the square root
     * operation
     */
    public ANFSqrtOp(ANFVarExp x){
        // TODO
        super(x);
    }

    @Override
    public void compile(int dest, Machine m){
        // TODO
        m.addSqrt(dest, getX().getN());
    }

    @Override
    public String toString(){
        return "(sqrt " + super.toString() + ")";
    }
    
}
