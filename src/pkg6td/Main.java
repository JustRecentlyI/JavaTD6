package pkg6td;

public class Main {

    public static void main(String[] args) {
        boolean devTest = false;//section gardÃ©e pour vÃ©rifier le bon fonctionnement de ReelContraint
        if(devTest) {
            //tests ReelContraint
            //2 objets diffÃ©rents equivalents
            ReelContraint r1 = new ReelContraint(5, 4, 4.5);
            ReelContraint r2 = new ReelContraint(4, 5, 4.5);

            //test methode affiche()
            r1.affiche();
            r2.affiche();

            //vÃ©rification getters
            System.out.println("r1.getMin() " + r1.getMin() + " r1.getMax() " + r1.getMax());
            System.out.println("r1.getVal() " + r1.getVal());
            System.out.println("r2.getMin() " + r2.getMin() + " r2.getMax() " + r2.getMax());
            System.out.println("r2.getVal() " + r2.getVal());

            //vÃ©rification equals
            System.out.println("r1 equals r2 ? " + r1.equals(r2));
            System.out.println("r1 equals 4.5 ? " + r1.equals(4.5));

            //vÃ©rification que les limites ne peuvent pas Ãªtre dÃ©passÃ©s
            ReelContraint r3 = new ReelContraint(3.2, 3.2, 27);
            System.out.println("r3.getMin() " + r3.getMin() + " r3.getMax() " + r3.getMax());
            System.out.println("r3.getVal() " + r3.getVal());

            //vÃ©rifcation du comportement du constructeur avec nombres nÃ©gatifs
            ReelContraint r4 = new ReelContraint(-7.2, -8.4, -54);
            //test methode toString
            System.out.println(r4);


            //tests Voyage
            //test comportement constructeur avec valeurs extremes
            Voyage v1 = new Voyage("", "", -2, 14);
            //test methode toString()
            System.out.println(v1);

            //creation d'objets pour tester les comparaison
            Voyage v2 = new Voyage("Lyon", "Marseille", 276, 3.2);
            Voyage v3 = new Voyage("Lyon", "Marseille", 17663, 0.05);
            //test equals
            System.out.println("v2.equals(v3) : "+v2.equals(v3));
            //test compareIntiinraire et comparePrix
            System.out.println("Comparer " + v2 + " et " + v3 + "\nLongueur");
            System.out.println(v2.compareItiniraire(v3));
            System.out.println("Prix:\n" + v2.comparePrix(v3));
        }
        //reponse question 4
        //crÃ©ation d'un tableau des voyages de l'agence
        Voyage[] tabVoyages = new Voyage[3];
        tabVoyages[0] = new Voyage("Lyon", "Paris", 470, 0.08);
        tabVoyages[1] = new Voyage("Lyon", "Paris", 400, 1.1);
        tabVoyages[2] = new Voyage("Lyon", "New York", 6205, 0.45);

        //affichage des voyages disponibles
        for(int i = 0; i < tabVoyages.length; i++){
            System.out.println(tabVoyages[i]);
        }

        //crÃ©ation d'un Scanner pour permettre la saisie utilisateur
        java.util.Scanner saisie = new java.util.Scanner(System.in);

        //saisie des villes par l'utilisateur
        System.out.println("Saisir votre destination voulue :");
        String destination = saisie.nextLine();//buffer videe par le nextLine directement
        System.out.println("Saisir votre ville de dÃ©part");
        String depart = saisie.nextLine();

        //cÅ•eation d'instances initiales des voyages le plus court et le moins cher
        //il sont initalisÃ©s aux limites supÃ©rieures des intervalles de distance et de cout
        Voyage voyagePlusCourt = new Voyage(depart, destination, 30000, 3.2);
        Voyage voyageMoinsCher = new Voyage(depart, destination, 30000, 3.2);

        //parcous tableau, on stocke le meilleur voyage correspondant aux villes saisies
        for(int i = 0; i < tabVoyages.length; i++){
            if(destination.equals(tabVoyages[i].getArrive()) && depart.equals(tabVoyages[i].getDepart())){
                voyagePlusCourt = voyagePlusCourt.compareItiniraire(tabVoyages[i]);
                voyageMoinsCher = voyageMoinsCher.comparePrix(tabVoyages[i]);
            }
        }
        //vÃ©rification qu'on n'est pas restÃ© Ã  la valeur initiale
        if(voyagePlusCourt.getLongueur() == 30000 && voyagePlusCourt.getPrixKilometre() == 3.2){
            //dans ce cas, on n'a pas trouvÃ© de voyage convenable
            System.out.println("Pas de voyages disponibles pour les villes saisies");
        }
        else if(voyageMoinsCher.equals(voyagePlusCourt)){
            //si le voyage le plus court est le moins cher aussi, on ne l'affiche qu'une seule fois
            System.out.println("Meilleur choix :\n"+voyageMoinsCher);
        }
        else{
            //Sinon, on affiche les meilleurs choix pour chaque catÃ©gorie
            System.out.println("Voyage meilleur prix :\n"+voyageMoinsCher+"\nVoyage le plus court :\n"+voyagePlusCourt);
        }
    }
}
