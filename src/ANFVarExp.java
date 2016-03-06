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
    }
    
    /**
     * Set the static count value to zero.
     * 
     */
    public static void reset(){
        // TO DO
    }
    
    /**
     * Get the number associated with the variable. 
     * 
     * @return the int that is the number associated with the variable
     */
    public int getN(){
        // TO DO
        return 0; // replace
    }
    
    @Override
    public void compile(Machine m){
        // TO DO
    }
    
    @Override
    public String toString(){
        return "t"+this.n;
    }
    
}
