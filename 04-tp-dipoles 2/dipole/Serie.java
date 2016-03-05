package dipole;

public class Serie extends Binaire implements Dipole {
    public Serie(Dipole d1,Dipole d2) {
        super(d1,d2);
    }
    public Complexe impedance(double omega) {
        return null;
    }
    public String toString() {
    	 return "Serie(??)";
    }

}
