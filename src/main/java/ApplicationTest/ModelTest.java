package ApplicationTest;

import application.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.sql.SQLException;
import java.util.Date;

/** 
 * Dans cette classe nous allons tester la connexion a la base de donnée
 * @author Abdou Khadre DIOP, Babacar FALL, Mohamed LEYE, Zaynabou DIA, Awa DIA
 * @date 4/08/2018
 * @version 1.0
 */
public class ModelTest {

    /**
     * le model qu'on va tester
     */
    private Model model;

    /**
     * Cette fonction est appele avant tous les autres test on y instancie le model a tester
     */
    @Before
    public void avantTest(){
        model = Model.getInstance();
        //on verifie si l'instance est null
        Assert.assertNotNull("Le model est null ",model);
    }

    /**
     * On verifie si la connexion a la base de donnée est effective
     */
	@Test
    public void getInstanceTest() {
        //on test la nature de lobjet renvoyer par la
        Assert.assertTrue("Lobjet renvoyer par la requette n'est pas celui attendu",model instanceof Model);
    }

    /**
     * On test la requete qui retourne l'historique dans un tableau
     * @throws SQLException en cas de probleme avec la connexion cette exception est renvoyer
     */
    @Test
    public void getHistoryTest() throws SQLException {
	    try {
            //on regarde dabord si linstance renvoyer est null
            Assert.assertNotNull(model.getHistory());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Ici on verifie si la requette est correctement inserer
     */
    @Test
    public void insertTest(){
        Assert.assertNotNull(model.insertStatement("2x2a+3b+c","2",new Date()));
    }
	
}
