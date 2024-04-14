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
### Joueur perdu:
  Jeu doit débiter le compte de joueur et le jeu s'arrête.
### Joueur gagne :
 Jeu doit créditer le compte de joueur avec  2 x mise .
### Jeu fermé
 Jeu se ferme si la banque est insolvale (ne peut pas accepter d'autres paris) .

## 4 . 
  Dans le cas ou Jeu est fermé, il s'agit d'un test d'état, car ce test consiste à vérifer la valeur de la variable state dans la classe jeu.
## 5. 
 dans le cas ou le joueur est insolvable, il s'agit d'un test d'interaction, car on vérifie si Jeu a intéragit avec la méthode lander de Dé.

  
