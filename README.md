# Le jeu de dé : 
## Les Objets à moquer sont : 
 ### Banque :
 - Pour vérifier si la banque est solvable.
 - Pour créditer et débiter la banque avec la mise et le gain respectivement.
 ### Joueur : 
   - Pour récupérer la mise de joueur.
   - débiter le compte de joueur juste après la mise.
   - créditer le compter de joueur en cas d'un bon pari .
 ### De : 
   - Pour tirer aléatoirement un nombre entre 1 et 6 .

## Les classes d'équivalences : 
### joueur insolvable :
  Jeu doit lever une JeuFermeException dans le cas ou joueuer n'a pas la somme à débiter de son comptre.
### Banque insolvable (Jeu fermé) :
  Jeu doit lever une JeuFermeException dans le cas ou la banque n'est pas solvable.
### Joueur perdu:
  Jeu doit débiter le compte de joueur et je jeu ferme.
### Joueur gagne et la banque n'est plus solvable:
 Jeu doit créditer le compte de joueur avec  2 x mise  en cas d'un bon pari et la banque ne peut plus accepter d'autres paris.
### Joueur gagne et la banque est toujours olvable: 
 Jeu doit créditer le compte de joueur avec  2 x mise  en cas d'un bon pari et la banque peut accepter d'autres paris.
  
