package dipole ;

public class  Complexe {
    // private la précision
    private static double EPSILON=1e-8;
    // les champs 
    private double reelle, imaginaire ;

    public Complexe(double re, double im){
        reelle = re ;
        imaginaire = im;
    }

    public double reelle() {
        return reelle ;
    }

    public double imaginaire() {
        return imaginaire ;
    }

    public Complexe add(Complexe c ){
        assert c != null;

        reelle = reelle + c.reelle;
        imaginaire = imaginaire + c.imaginaire;
        return this;
    }

    public Complexe inverse() {
        assert Math.abs(reelle()) > 0.0001 || Math.abs(imaginaire()) > 0.0001;

        double m = reelle * reelle + imaginaire * imaginaire;
        reelle = reelle / m ;
        imaginaire = - imaginaire / m;
        return this;
    }

    public String toString(){
        return (reelle + " + " + imaginaire + "i");
    }

    public boolean equals(Object o) {
        if (o==null || !(o instanceof Complexe))
            return false;
        Complexe c = (Complexe) o;
        if (Math.abs(c.reelle - this.reelle) > EPSILON) {
            return false;
        }
        if (Math.abs(c.imaginaire - this.imaginaire) > EPSILON)
            return false;
        return true;
    }
}



