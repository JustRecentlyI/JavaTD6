package pkg6td;

public class Voyage {
    private String depart;
    private String arrive;
    private final EntierContraint longueur;
    private final ReelContraint prixKilometre;

    //crÃ©ation d'un objet d'erreur pour Ã©viter d'utiliser return null;
    public static Voyage NON_TROUVE = new Voyage("ERREUR", "ERREUR", 300000, 3.2);

    public Voyage(String depart, String arrive, int distance, double coutKilometre){
        this.depart = depart;
        this.arrive = arrive;
        /*note: si la distance ou le cout dÃ©passe l'intervalle spÃ©cifiÃ©e,
        on considÃ¨re que la valeur sera la borne infÃ©rieure ou supÃ©rieurs
        selon le cas. Ã€ ce stade, on ne peut pas faire autrement.
        */
        //seule la valeur de distance et de cout peuvent changer, leur limites sont prÃ©dÃ©finies, d'oÃ¹ int et double dans le constructeur
        longueur = new EntierContraint(1,30000, distance);
        prixKilometre = new ReelContraint(0.05, 3.2, coutKilometre);
    }

    public String getDepart(){
        return depart;
    }

    public String getArrive() {
        return arrive;
    }
    //renvoie la valeur (pas besoin de connaitre les limites)
    public int getLongueur(){
        return longueur.getVal();
    }
    //renvoie la valeur (pas besoin de connaitre les limites)
    public double getPrixKilometre(){
        return prixKilometre.getVal();
    }

    public void setDepart(String depart){
        this.depart = depart;
    }
    public void setArrive(String arrive){
        this.arrive = arrive;
    }

    //on n'a besoin d'accÃ¨der qu'Ã  la valeur
    public void setLongueur(int distance) {
        longueur.setVal(distance);
    }

    //on n'a besoin d'accÃ¨der qu'Ã  la valeur
    public void setPrixKilometre(double cout) {
        prixKilometre.setVal(cout);
    }

    public Voyage compareItiniraire(Voyage voyage){
        //ne peut comparer que 2 voyages partant et arrivant aux mÃªmes villes
        if(this.depart.equals(voyage.getDepart()) && this.arrive.equals(voyage.getArrive())){
            //renvoie le plus court
            if(this.getLongueur() < voyage.getLongueur()) return this;
            //return voyage n'est executÃ© que si la condition n'est pas validÃ©e
            return voyage;
        }
        else{
            //renvoie une valeur d'erreur si les deux voyages n'ont pas les mÃªmes villes de dÃ©part et d'arrivÃ©e
            return Voyage.NON_TROUVE;//pourrait aussi Ãªtre une exception
        }
    }

    public Voyage comparePrix(Voyage voyage){
        //ne peut comparer que 2 voyages partant et arrivant aux mÃªmes villes
        if(this.depart.equals(voyage.getDepart()) && this.arrive.equals(voyage.getArrive())){
            //renvoie le moins cher
            if(this.getLongueur() * this.getPrixKilometre() < voyage.getLongueur() * voyage.getPrixKilometre()) return this;
            //return voyage n'est executÃ© que si la condition n'est pas validÃ©e
            return voyage;
        }
        else{
            //renvoie une valeur d'erreur si les deux voyages n'ont pas les mÃªmes villes de dÃ©part et d'arrivÃ©e
            return Voyage.NON_TROUVE;//pourrait aussi Ãªtre une exception
        }
    }

    @Override
    public boolean equals(Object o){
        //comparaison Ã  un objet vide
        if(o == null) return false;
        //vÃ©rification qu'on compare Ã  un objet de type Voyage
        if(!(o instanceof Voyage) ) return false;
        //cette patie du code ne sera exÃ©cutÃ©e seulement si la condition prÃ©alable n'est pas remplie.
        Voyage v = (Voyage) o;
        //ne sont Ã©gaux que si touts attributs sont Ã©gaux
        return (this.arrive.equals(v.getArrive()) && this.depart.equals(v.getDepart())
                && this.longueur.getVal() == v.getLongueur() && this.prixKilometre.getVal() == v.getPrixKilometre());
    }

    
    @Override
    public String toString(){
        return "Voyage entre "+this.depart+" et "+this.arrive+", de "+this.longueur.getVal()+"km et coutant "+this.prixKilometre.getVal()+" au km";
    }
    
}
