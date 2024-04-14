package org.example;

public class Jeu {
    private final Banque banque;
    private boolean ferm;
    private boolean arreter;
    public Jeu(Banque labanque){
        this.banque = labanque;
        ferm = !banque.est_solvable();
        arreter = false;
    }
    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!ferm) {
            // récupérer la mise de joueur
            int mis = joueur.mise();
            // débiter de compte de joueur et créditer la banque avec la somme mise
            try {
                joueur.debiter(mis);
            } catch (DebitImpossibleException e) {
                throw new JeuFermeException("Le joueur n'a pas assez de crédit");
            }
            banque.crediter(mis);
            // lancer les dés
            int pari1 = de1.lancer();
            int pari2 = de2.lancer();
            //vérifier si égale à 7
            if (pari1 + pari2 == 7) {
                //débiter la banque avec deux fois la somme mise
                banque.debiter(mis * 2);
                // rajouter le montant au compte de joueur
                joueur.crediter(mis * 2);
                // vérifier si la banque est toujours solvable
                if (!banque.est_solvable()) {
                    // fermer  le jeu si la banque n'est pas solvable
                    this.fermer();
                }
             /*
             le jeu contiue sinon
              */
            } else {
                /*
                le jeu s'arrête s'il a perdu
               */
                arreter = true;
            }
        }
        }

        public void fermer () {
            this.ferm = true;
        }
        ;
        public boolean estOuvert () {
            return !ferm;
        }
        public boolean estArrete (){
            return arreter;
        }
}
