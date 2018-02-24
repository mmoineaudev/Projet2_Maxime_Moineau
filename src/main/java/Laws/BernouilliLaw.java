package Laws;

import Exceptions.CalculationException;
import Exceptions.LawException;
import tools.Displayable;

/**
 * Created by maxime on 09/03/17.
 */
public class BernouilliLaw implements Law, Displayable, DiscreteLaw {
    private double probSucces;
    public BernouilliLaw(double probSucces) throws LawException {
        this.probSucces = probSucces;
        if(!(probSucces>0 && probSucces<1)) throw new LawException("Invalid parameters probSucces="+probSucces);
    }

    /**
     * Retourne 0 en cas de parametre incorrect
     * @param x_egal_i
     * @return
     * @throws CalculationException
     */
    public double getProbabiliteDeX(int x_egal_i) throws CalculationException {
        Law.printcalcul("P(X="+x_egal_i+")", "(x_egal_i==0||x_egal_i==1)?((x_egal_i==1)?probSucces:1-probSucces):0." );
        return (x_egal_i==0||x_egal_i==1)?
                //1 ou 0 ? :
                ((x_egal_i==1)?probSucces:1-probSucces)
                //sinon P(X=x_egal_i)=0
                :0.;
    }

    @Override
    public double getEsperance() {
        Law.printcalcul("E[X]", "probabilité de succés = " + probSucces);
        return probSucces;
    }

    @Override
    public double getVariance() {
        Law.printcalcul("V[X]", "probSucces*(1-probSucces)="+probSucces+"*(1-"+probSucces+")");
        return probSucces*(1-probSucces);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String display() {
        return Displayable.title_prefix+getName()+
                "X suit une loi de Bernouilli de paramètre p ∈]0; 1[ si :\n"+
                "X ne prend que les valeurs 0 et 1,\n" +
                "P(X = 1) = p et P(X = 0) = 1 − p"
                +"\n Ici on a " +getParameters();
    }

    @Override
    public String getParameters() {
        return "probabilité de succés : "+probSucces;
    }
}
