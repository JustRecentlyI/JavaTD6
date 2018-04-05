package pkg6td;

public class ReelContraint {
    private final double min;
    private final double max;
    private double val;

    public ReelContraint(double a, double b, double val) {
        //on choisit le minimum entre les deux bornes propoÃ©s sans tenir compte de leur ordre dans le constructeur
        if (a > b) {
            min = b;
            max = a;
        } else {
            min = a;
            max = b;
        }
        /*ne permet pas de sortir de l'intervalle, est automatiquement bloquÃ©e sur la borne la plus proche si la valeur
        proposÃ©e dÃ©passe les bornes dÃ©finies*/
        if(val < min){
            this.val = min;
        }
        else if (val > max){
            this.val = max;
        }
        else{
            this.val = val;
        }
    }
    public void affiche(){
        System.out.println(val);
    }
    public void saisir(){
        //permet de demander la saisie utilisateur de la valeur directement
        java.util.Scanner scan = new java.util.Scanner(System.in);
        double test;
        do {
            System.out.println("Entrez une valeur dans l'intervalle [" + min + " ; " + max + "] :");
            test = scan.nextDouble();
            scan.nextLine();//vidage de buffer
        }while(test < min || test > max);
        //rÃ©pÃ¨te jusqu'Ã  qu'une valeur correcte est saisie
        val = test;
    }

    public void incr(double i)
    {
        /*ne permet pas de sortir de l'intervalle, est automatiquement bloquÃ©e sur la borne la plus proche si la valeur
        proposÃ©e dÃ©passe les bornes dÃ©finies*/
        if(val + i <=max && val + i >= min){
            val = val + i;
        }
        else if(val+ i < min){
            val = min;
        }
        else{
            val = max;
        }
    }


    public double getMin(){
        return min;
    }
    public double getMax(){
        return max;
    }
    public double getVal(){
        return val;
    }

    public void setVal(double reel) {
        /*ne permet pas de sortir de l'intervalle, est automatiquement bloquÃ©e sur la borne la plus proche si la valeur
        proposÃ©e dÃ©passe les bornes dÃ©finies*/
        if(reel < min){
            this.val = min;
        }
        else if (reel > max){
            this.val = max;
        }
        else{
            this.val = reel;
        }
    }

    @Override
    public boolean equals(Object o){
        //comparaison Ã  un objet vide
        if(o == null) return false;
        //vÃ©rification qu'on compare Ã  un objet de type ReelContraint
        if(!(o instanceof ReelContraint) ) return false;
        //cette patie du code ne sera exÃ©cutÃ©e seulement si la condition prÃ©alable n'est pas remplie.
        ReelContraint r = (ReelContraint) o;
        //ne sont Ã©gaux que si touts attributs sont Ã©gaux
        return (r.getMax()==this.max && r.getMin()==this.min && r.getVal()==this.val);
    }

    @Override
    public String toString(){
        return "Reel "+this.val+" contraint sur ["+this.min+" ; "+this.max+"]";
    }
}
