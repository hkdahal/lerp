/**
 * A representation of the holder lerp expression.  This class allows
 * (ANF) variables to be a part of an Expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class Holder implements Expression {

    private ANFVarExp t;

    /**
     * Construct a holder expression.
     *
     * @param t the ANFVarExp that is the variable
     */
    public Holder(ANFVarExp t){
        // TODO
        this.t = t;
    }

    /**
     * A selector for getting the variable from the holder.
     *
     * @return the ANFVarExp that is the variable
     */
    public ANFVarExp getVar(){
        // TODO
        return t; // TODO replaced
    }

    @Override
    public ANFExp toANF(){
        // TODO
        return getVar(); // TODO replaced
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        Errors.error("Shouldn't get here: extract of Holder.", null);
        return null;
    }

    @Override
    public String toString(){
        return this.t.toString();
    }
}
