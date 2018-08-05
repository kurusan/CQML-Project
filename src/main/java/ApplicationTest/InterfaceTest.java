package ApplicationTest;

import application.Controller;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.gen5.api.extension.ExtendWith;
import static org.testfx.assertions.api.Assertions.assertThat;


/**
 * Dans cette classe nous allons tester linterface et les resultats retourne
 * @author Abdou Khadre DIOP, Babacar FALL, Mohamed LEYE, Zaynabou DIA, Awa DIA
 * @date 4/08/2018
 * @version 1.0
 */
public class InterfaceTest {

    private final String ID_BOUTTON_VALIDER = "submitButton";
    private final String ID_A_TEXT = "firstOp";
    private final String ID_B_TEXT = "secondOp";
    private final String ID_C_TEXT = "thirdOp";
    private final String ID_RESULT_TEXT = "resultField";

    private Controller controller;

    private double x1, x2;

    /**
     * Initialisons la page
     */
    @BeforeClass
    private void initPage(){

    }


    /**
     * Test equation
     */
    @Test
    private void testEquation(){


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
