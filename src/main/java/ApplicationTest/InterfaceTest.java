package ApplicationTest;

import application.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

import static org.testfx.assertions.api.Assertions.assertThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.matcher.base.NodeMatchers;


/**
 * Dans cette classe nous allons tester linterface et les resultats retourne
 * @author Abdou Khadre DIOP, Babacar FALL, Mohamed LEYE, Zaynabou DIA, Awa DIA
 * @date 4/08/2018
 * @version 1.0
 */

public class InterfaceTest extends ApplicationTest{

    private final String ID_BOUTTON_VALIDER = "#submitButton";
    private final String ID_A_TEXT = "#firstOp";
    private final String ID_B_TEXT = "#secondOp";
    private final String ID_C_TEXT = "#thirdOp";
    private final String ID_RESULT_TEXT = "#resultField";

    private Controller controller;

    private double x1, x2;

    /**
     * Initialisons la page
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Users/user/Documents/master/cqml/CQML/2nddegre/2ndApp/src/main/java/ApplicationTest/MainScene.fxml"));
        Controller controleur= new Controller();
        loader.setController(controleur);
        Parent root = loader.load();
        primaryStage.setTitle("Application de resolution équation 2nd degré dans R");
        primaryStage.setScene(new Scene(root,840,600));
        primaryStage.show();
    }

    /**
     * on verifie si le champs a est dans linterface
     */
    @Test
    public void champAExiste(){
        verifyThat(ID_A_TEXT, NodeMatchers.isNotNull());
    }

    /**
     * on verifie si le champs b est dans linterface
     */
    @Test
    public void champBExiste(){
        verifyThat(ID_B_TEXT, NodeMatchers.isNotNull());
    }

    /**
     * on verifie si le champs c est dans linterface
     */
    @Test
    public void champCExiste(){
        verifyThat(ID_C_TEXT, NodeMatchers.isNotNull());
    }

    /**
     * on verifie si le boutton est dans linterface
     */
    @Test
    public void bouttonValiderExiste(){
        verifyThat(ID_BOUTTON_VALIDER, NodeMatchers.isNotNull());
    }

    /**
     * on verifie si le champs resultat est dans linterface
     */
    @Test
    public void bouttonResultatExiste(){
        verifyThat(ID_RESULT_TEXT, NodeMatchers.isNotNull());
    }



    /**
     * Ici on regarde si le resultat renvoyer par linterface est le bon
     */
    @Test
    public void resolutionEquation(){
        // inserons tout dabord les données

    }





    /**
     * Cette fonction va nous servir de reference pour tester si notre interface fonctionne bien
     * Elle renvoie vrai quand il a une une solution et faux sinon de plus les resultat x1 et x2
     * Sont initialises dans les variables global
     * @param a la valeur de a
     * @param b la valeur de b
     * @param c la valeur de c
     * @return vrai si il ya une solution faux sinon
     */
    private boolean resolution(double a, double b, double c){
        double delta;
        delta = (b*b) - 4*a*c;
        if (delta<0)
        {
            return false;
        }
        else {
            x1 = (-b - Math.sqrt(delta)) / (2 * a);
            x2 = (-b + Math.sqrt(delta)) / (2 * a);
            return true;
        }
    }
}
