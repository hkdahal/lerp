/**
 * A representation of the division operation for ANF-expressions.
 *
 * @author Arthur Nunes-Harwitt
 */
public class ANFDivOp extends ANFBinOp {

    /**
     * Construct an ANF division operation.
     *
     * @param x1 the ANFVarExp that is the first operand of the
     * division operation
     * @param x2 the ANFVarExp that is the second operand of the
     * division operation
     */
    public ANFDivOp(ANFVarExp x1, ANFVarExp x2){
        // TODO
    }

    @Override
    public void compile(int dest, Machine m){
        // TODO
    }

    @Override
    public String toString(){
        return "(/ " + super.toString() + ")";
    }
    
}
