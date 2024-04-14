import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import org.example.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceExo3Test {
    @Mock
    private UtilisateurApi utilisateurApiMock;
    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        // TODO :Lever une exception lors de la création de l'utilisateur avec l’exception
        //ServiceException("Echec de la création de l'utilisateur").
        doThrow(new ServiceException("Echec de la création de l'utilisateur")).when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // TODO : Tester le comportement en cas d'erreur de validation
        UserService userService = new UserService(utilisateurApiMock);
        Assertions.assertThrows(ServiceException.class, ()->userService.creerUtilisateur(utilisateur));
        //reset le comportement de l'objet mocké
        reset(utilisateurApiMock);
    }

    @Test
    public void testCreerUtilisateurErreurDeValidation() throws ServiceException{
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        // mocker l'objet
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(-1);
        // création d'un user service
        UserService us = new UserService(utilisateurApiMock);
        // vérifier que l'utilisateur n'a pas été crée
        Assertions.assertEquals(-1, us.creerUtilisateur(utilisateur));

    }

    @Test
    public void testCreerUtilisateurId() throws ServiceException{
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        UserService userService = new UserService(utilisateurApiMock);
        // Définition d'un ID fictif
        int idUtilisateur = 123;
        // TODO: Configuration du mock pour renvoyer l'ID
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(idUtilisateur);
        // Appel de la méthode à tester
        int returnedId = userService.creerUtilisateur(utilisateur);
        // TODO: Vérification de l'ID de l'utilisateur
        Assertions.assertEquals(idUtilisateur,userService.creerUtilisateur(utilisateur));


    }

    @Test
    public void testCreerUtilisateurArgCaptor() throws ServiceException{
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        UserService userService = new UserService(utilisateurApiMock);
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(1);
        ArgumentCaptor<Utilisateur> argumentCaptor =
                ArgumentCaptor.forClass(Utilisateur.class);
        userService.creerUtilisateur(utilisateur);
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur capturedUser = argumentCaptor.getValue();
        Assertions.assertEquals(utilisateur,capturedUser);

    }
}