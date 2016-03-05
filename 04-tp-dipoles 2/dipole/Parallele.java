package dipole;

public class Parallele extends Binaire implements Dipole {
    public Parallele(Dipole d1,Dipole d2) {
        super(d1,d2);
    }
    @Override
    public Complexe impedance(double omega) {
        return null;
    }
    public String toString() {
    	 return "Parallele(??)";
    }
}
