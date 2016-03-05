package dipole;

public class NSerie extends NAire {
    public NSerie(Dipole[] t) {
        super(t);
    }

    @Override
    public Complexe impedance(double omega) {
        return null;
    }
    public String toString() {
    	 return "Serie(??)";
    }

}
