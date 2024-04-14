import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JeuTest {
    @Mock
    private Banque banqueMock;
    @Mock
    private Joueur joueurMock;
    @Mock
    private De de1Mock;
    @Mock
    private De de2Mock;

    @Test
    public void jeuSeFermeSiLaBanqueEstInsolvable(){
        when(banqueMock.est_solvable()).thenReturn(false);
        Jeu jeu = new Jeu(banqueMock);
        Assertions.assertFalse(jeu.estOuvert());

    }
    @Test
    public void jeuThrowsJeuFermeExceptionIfJoueurEstNonSolvable() throws DebitImpossibleException,JeuFermeException{


         int somme = 100;
         when(banqueMock.est_solvable()).thenReturn(true);
         doThrow(new DebitImpossibleException("le joueur n'a pas assez de crédit")).when(joueurMock).debiter(somme);
         when(joueurMock.mise()).thenReturn(somme);
         Jeu jeu = new Jeu(banqueMock);
         Assertions.assertThrows(JeuFermeException.class, ()->jeu.jouer(joueurMock,de1Mock,de2Mock));
         verify(de1Mock, never()).lancer();
         verify(de2Mock, never()).lancer();

    }

    @Test
    public void jeuArreteApresQueLeJoueurPerd() throws DebitImpossibleException,JeuFermeException{
        int somme = 100;
        when(banqueMock.est_solvable()).thenReturn(true);
        when(de1Mock.lancer()).thenReturn(1);
        when(de2Mock.lancer()).thenReturn(2);
        doNothing().when(banqueMock).crediter(somme);
        when(joueurMock.mise()).thenReturn(somme);
        doNothing().when(joueurMock).debiter(somme);

         Jeu jeu = new Jeu(banqueMock);
         jeu.jouer(joueurMock,de1Mock,de1Mock);
         Assertions.assertTrue(jeu.estArrete());

    }

    @Test
    public void jeuContinueApresQueLeJoueurGagneEtLaBanqueEstSolvable() throws DebitImpossibleException,JeuFermeException{
        int somme = 100;
        when(banqueMock.est_solvable()).thenReturn(true);
        when(de1Mock.lancer()).thenReturn(5);
        when(de2Mock.lancer()).thenReturn(2);
        doNothing().when(banqueMock).crediter(somme);
        doNothing().when(banqueMock).debiter(2 * somme);
        when(joueurMock.mise()).thenReturn(somme);
        doNothing().when(joueurMock).debiter(somme);
        doNothing().when(joueurMock).crediter(2 * somme);

        Jeu jeu = new Jeu(banqueMock);
        jeu.jouer(joueurMock,de1Mock,de1Mock);
        Assertions.assertTrue(jeu.estOuvert());

    }
}
