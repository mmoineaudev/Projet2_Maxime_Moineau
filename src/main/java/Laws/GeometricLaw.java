package Laws;

import Exceptions.CalculationException;
import Exceptions.LawException;
import tools.Displayable;


public class GeometricLaw implements Law, Displayable, DiscreteLaw {

    private double proba_reussite;

    public GeometricLaw(double probabilite) throws LawException {
        proba_reussite = probabilite;
        if(!(probabilite<1||probabilite>0)){
            throw new LawException(this.getClass(), "probabilite"+probabilite);
        }
    }


    public double getProbabiliteDeX(double x_egal_i) {
        return Math.pow(1.-proba_reussite, x_egal_i-1.)*proba_reussite;
    }

    public double getEsperance(){
        Law.printcalcul("E[X]", "1/proba_reussite = 1/"+proba_reussite+"="+ (1/proba_reussite));
        return 1./proba_reussite;
    }

    @Override
    public double getVariance() {
        Law.printcalcul("V[X]", "(1-proba_reussite)/(proba_reussite^2) = (1-"+proba_reussite+")/("+proba_reussite+"*"+proba_reussite+")");
        return (1-proba_reussite)/(proba_reussite*proba_reussite);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String display() {
        return Displayable.title_prefix+getName()+Displayable.closure+"\n"+getParameters();
    }

    @Override
    public String getParameters() {
        return "pSuccess = "+proba_reussite ;
    }

    @Override
    public double getProbabiliteDeX(int x_egal_i) throws CalculationException {
        Law.printcalcul("P(X)", "((1.-proba_reussite)^(x_egal_i-1.))*proba_reussite=((1.-"+proba_reussite+")^("+x_egal_i+"-1.))*"+proba_reussite+"="+Math.pow(1.-proba_reussite, x_egal_i-1.)*proba_reussite);
        return Math.pow(1.-proba_reussite, x_egal_i-1.)*proba_reussite;
    }
}
