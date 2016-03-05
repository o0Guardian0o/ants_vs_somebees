package dipole;

import org.junit.Test;

public class TestsAutomatiques {
    @Test
    public void testSelf() {
        Dipole s = new Self(7*1e-2);
        Complexe expected = new Complexe(0,21.9912);
        Complexe got = s.impedance(314.16);
        org.junit.Assert.assertEquals(
                "Un self de valeur 7*1e-2 doit avoir une impedence de "+expected+", pas "+got,
                expected,got);
    }
    
    @Test
    public void testCapacite() {
        Dipole s = new Capacite(42);
        Complexe expected = new Complexe(0,-7.578789*1e-5);
        Complexe got = s.impedance(314.16);
        org.junit.Assert.assertEquals(
                "Une capacite de valeur 42 doit avoir une impedence de "+expected+", pas "+got,
                expected,got);
    }
    
    @Test
    public void testResistance() {
    	Dipole r = new Resistance(1e2);
    	Complexe expected = new Complexe(100,0);
    	Complexe got = r.impedance(314.16);
        org.junit.Assert.assertEquals(
                "Une résistance de valeur 100 doit avoir une impedence de "+expected+", pas "+got,
                expected,got);
    }
    
    @Test
    public void testSerie() {
        double omega = 314.16 ; 
        Dipole dip2 = new Serie(new Self(5e-2), new Resistance(1e2)) ;
        Complexe expected = new Complexe(100,15.708);
        Complexe got = dip2.impedance(omega);
        org.junit.Assert.assertEquals(
                "Erreur dans le calcul de la série",
                expected,got);
    }
    
    @Test
    public void testParallele() {
        double omega = 314.16 ; 
        Complexe got;

        Complexe expected = new Complexe(0,-4.564497387210561);
        Dipole dip2 =  new Parallele( new Self(5e-2), new Capacite(9e-4));
        got = dip2.impedance(omega);
        org.junit.Assert.assertEquals("Echec du calcul du parallelle",expected, got);
        
        expected = new Complexe(0.2079131844185524, -4.55500719534011);
        Dipole dip3 = new Parallele( new Resistance(1e2), 
                new Parallele( new Self(5e-2), 
                               new Capacite(9e-4))) ;
        got = dip3.impedance(omega);
        org.junit.Assert.assertEquals("Echec du calcul du parallelle",expected, got);
    }
    
    @Test
    public void testNaire() {
        double omega = 314.16 ; 
        Complexe expected = new Complexe(104.96041500196952,60.76416082442783);

        // test sans utiliser les operateurs n-aires
        Dipole dip4a =
            new Serie(new Resistance(1),
                      new Parallele(new Resistance(1e7),
                                    new Parallele(new Capacite(1e-6),
                                                  new Serie(new Resistance(1e2),
                                                            new Self(2e-1))))) ;
        Complexe got = dip4a.impedance(omega);
        org.junit.Assert.assertEquals("Echec du calcul du Naire sans utiliser de tableaux",expected, got);
        
        // test en utilisant les operateurs n-aires
        Dipole [] t1 = {new Resistance(1e2), new Self(2e-1)} ;
        Dipole d1 = new NSerie(t1) ;
        expected = new Complexe(100,62.832);
        got = d1.impedance(omega);
        org.junit.Assert.assertEquals("Echec du calcul de la partie basse",expected, got);
        

        Dipole d2 = new Resistance(1e7) ;
        Dipole d3 = new Capacite(1e-6) ; 
        Dipole [] t2 = {d2, d3, d1} ;
        Dipole d4 = new NParallele(t2) ;
        expected = new Complexe(103.96041500196952, 60.76416082442782);
        got = d4.impedance(omega);
        org.junit.Assert.assertEquals("Echec du calcul de la partie de droite",expected, got);
        
        
        Dipole d5 = new Resistance(1f) ;
        Dipole [] t3 = {d5, d4};         
        Dipole dip4 = new NSerie(t3) ;
        expected = new Complexe(104.96041500196952,60.76416082442782);
        got = dip4.impedance(omega);
        org.junit.Assert.assertEquals("Echec du calcul du gros Naire en utilisant les tableaux",expected, got);
    }
    
    @Test
    public void testVariable() {
        double omega = 314.16 ; 
        Complexe expected = new Complexe(104.96041500196952,60.76416082442782);


        // test en utilisant les operateurs n-aires <E0> taille variable
        NAireVariable d1 = new VSerie();
        d1.addDipole(new Resistance(1e2));
        d1.addDipole(new Self(2e-1));


        Dipole d2 = new Resistance(1e7) ;
        Dipole d3 = new Capacite(1e-6) ; 

        NAireVariable d4 = new VParallele();
        d4.addDipole(d2);
        d4.addDipole(d3);
        d4.addDipole(d1);
        
        Dipole d5 = new Resistance(1f) ;
        
        NAireVariable dip4 = new VSerie();
        dip4.addDipole(d5);
        dip4.addDipole(d4);
             
        Complexe got = dip4.impedance(omega);
        org.junit.Assert.assertEquals("Echec du calcul du Naire en utilisant les ArrayList",expected, got);
    }
    
    @Test
    public void testToString() {
    	String expected,got;
    	expected="Resistance(12.0)";
    	got = new Resistance(12).toString();
        org.junit.Assert.assertEquals("Resistance.toString() ne fonctionne pas",expected, got);
    	
    	expected="Self(12.0)";
    	got = new Self(12.0).toString();
        org.junit.Assert.assertEquals("Self.toString() ne fonctionne pas",expected, got);
        
    	expected="Capacite(12.0)";
    	got = new Capacite(12).toString();
        org.junit.Assert.assertEquals("Capacite.toString() ne fonctionne pas",expected, got);
        
    	expected="Serie(Resistance(12.0), Self(12.0))";
    	got = new Serie(new Resistance(12), new Self(12)).toString();
        org.junit.Assert.assertEquals("Serie.toString() ne fonctionne pas",expected, got);

        expected="Parallele(Resistance(12.0), Self(12.0))";
    	got = new Parallele(new Resistance(12), new Self(12)).toString();
        org.junit.Assert.assertEquals("Parallele.toString() ne fonctionne pas",expected, got);

        Dipole[] d = { new Resistance(12), new Capacite(12), new Self(12) };
    	expected="Serie(Resistance(12.0), Capacite(12.0), Self(12.0))";
    	got = new NSerie(d).toString();
        org.junit.Assert.assertEquals("NSerie.toString() ne fonctionne pas",expected, got);

    	expected="Parallele(Resistance(12.0), Capacite(12.0), Self(12.0))";
    	got = new NParallele(d).toString();
        org.junit.Assert.assertEquals("NParallele.toString() ne fonctionne pas",expected, got);

    	expected="Serie(Resistance(12.0), Capacite(12.0), Self(12.0))";
    	VSerie vs = new VSerie();
    	vs.addDipole(new Resistance(12));
    	vs.addDipole(new Capacite(12));
    	vs.addDipole(new Self(12));
    	got = vs.toString();
        org.junit.Assert.assertEquals("VSerie.toString() ne fonctionne pas",expected, got);

    	expected="Parallele(Resistance(12.0), Capacite(12.0), Self(12.0))";
    	VParallele vp = new VParallele();
    	vp.addDipole(new Resistance(12));
    	vp.addDipole(new Capacite(12));
    	vp.addDipole(new Self(12));
    	got = vp.toString();
        org.junit.Assert.assertEquals("VParallele.toString() ne fonctionne pas",expected, got);
    }
    
    @Test
    public void testInstances() {
        double omega = 314.16 ; 
    	Dipole dip1 = Instances.dip1();
 
	   	String expectedS = "Parallele(Resistance(100.0), Serie(Self(5.0E-5), Resistance(12000.0)), Capacite(9.000000000000001E-9))";
	    String gotS = dip1.toString();
	    org.junit.Assert.assertEquals("Echec de l'instanciation de dip1", expectedS, gotS);

		Complexe expected = new Complexe(99.17354592177011, -0.02780791066116556);
        Complexe got = dip1.impedance(omega);
        org.junit.Assert.assertEquals("Echec de l'instanciation de dip1", expected, got);

    	
    	Dipole dip2 = Instances.dip2();

    	String expectedS2="Serie(Resistance(100.0), Parallele(Serie(Parallele(Serie(Resistance(1000.0), Self(5.0E-5)), Capacite(0.009000000000000001), Serie(Capacite(9.000000000000001E-4), Capacite(1.0E-5))), Resistance(330.0)), Serie(Resistance(1000.0), Self(0.2))), Capacite(1.0E-6))";
    	String gotS2 =dip2.toString();
        org.junit.Assert.assertEquals("Echec de l'instanciation de dip2", expectedS2, gotS2);

		Complexe expected2 = new Complexe(348.30897600031903, -3179.4318289334137);
        Complexe got2 = dip2.impedance(omega);
        org.junit.Assert.assertEquals("Echec de l'instanciation de dip2", expected2, got2);
    }
}
