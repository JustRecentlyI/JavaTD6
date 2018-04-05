package pkg6td;

public class EntierContraint{

    private final int min;//surtout pas de valeurs par dÃ©faaut
    private final int max;
    private int val;


    public EntierContraint(int a, int b, int val) {
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

    public void affiche()
    {
        System.out.println(val);
    }
    public void saisir()
    {
        //permet de demander la saisie utilisateur de la valeur directement
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int test;
        do {
            System.out.println("Entrez une valeur dans l'intervalle [" + min + " ; " + max + "] :");
            test = scan.nextInt();
            scan.nextLine();//vidage de buffer
        }while(test < min || test > max);
        //rÃ©pÃ¨te jusqu'Ã  qu'une valeur correcte est saisie
        val = test;
    }
    public void incr(int i)
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

    public int getMin() {
        return min;
    }
    public int getMax(){
        return max;
    }
    public int getVal(){
        return val;
    }
    public void setVal(int val){
        /*ne permet pas de sortir de l'intervalle, est automatiquement bloquÃ©e sur la borne la plus proche si la valeur
        proposÃ©e dÃ©passe les bornes dÃ©finies*/
        if(val < min)
        {
            this.val = min;
        }
        else if(val> max)
        {
            this.val = max;
        }
        else
        {
            this.val = val;
        }
    }
    @Override
    public boolean equals(Object o){
        //comparaison Ã  un objet vide
        if(o == null) return false;
        //vÃ©rification qu'on compare Ã  un objet de type EntierContraint
        if(!(o instanceof EntierContraint) ) return false;
        //cette patie du code ne sera exÃ©cutÃ©e seulement si la condition prÃ©alable n'est pas remplie.
        EntierContraint r = (EntierContraint) o;
        //ne sont Ã©gaux que si touts attributs sont Ã©gaux
        return (r.getMax()==this.max && r.getMin()==this.min && r.getVal()==this.val);
    }

    @Override
    public String toString(){
        return "Entier "+this.val+" contraint sur ["+this.min+" ; "+this.max+"]";
    }
}


