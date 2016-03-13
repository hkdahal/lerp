/**
 * A representation of the variable ANF-expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class ANFVarExp implements ANFExp {
    
    private static int count = 0;
    
    private int n;
    
    /**
     * Construct a variable ANF-expression.  The number associated
     * with the variable is taken from the current static count value.
     * It also increments the static count value.
     *
     */
    public ANFVarExp(){
        // TO DO
        n = count;
        count++;
    }
    
    /**
     * Set the static count value to zero.
     * 
     */
    public static void reset(){
        // TO DO
        count = 0;
    }
    
    /**
     * Get the number associated with the variable. 
     * 
     * @return the int that is the number associated with the variable
     */
    public int getN(){
        // TO DO
        return n; // replaced
    }


    /**
     * Compile the ANF-expression to target code.
     *
     * @param m the Machine where the instructions are being added
     */
    @Override
    public void compile(Machine m){
        // TO DO
        // target code??
        m.addPrint(getN());

    }
    
    @Override
    public String toString(){
        return "t"+this.n;
    }
    
}
