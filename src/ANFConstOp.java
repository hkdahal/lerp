/**
 * A representation of the constants for ANF-expressions.  Constants
 * are viewed as a trivial kind of operation.
 *
 * @author Arthur Nunes-Harwitt
 */
public class ANFConstOp implements ANFOp {

    private double num;

    /**
     * Construct an ANF constant.
     *
     * @param num the double that is the constant
     */
    public ANFConstOp(double num){
        // TODO
        this.num = num;
    }

    @Override
    public void compile(int dest, Machine m){
        // TODO
        m.addLdi(dest, num);
    }

    @Override
    public String toString(){
        return "" + this.num;
    }
}
