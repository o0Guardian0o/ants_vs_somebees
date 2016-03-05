package dipole;

public class NParallele extends NAire {

    public NParallele(Dipole[] t) {
        super(t);
    }
    
    @Override
    public Complexe impedance(double omega) {
        return null;
    }
    public String toString() {
    	 return "Parallele(??)";
    }

}
