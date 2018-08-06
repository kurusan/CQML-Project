package ApplicationTest;

import application.Controller;
import groovyjarjarantlr.debug.GuessingEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.testfx.assertions.api.Assertions.assertThat;


import org.hamcrest.core.Is;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.TextMatchers;
import org.testfx.service.query.NodeQuery;
import org.testfx.util.NodeQueryUtils;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;



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
    private final String ID_BOUTTON_SUPPRIMER = "";

    private double x1, x2;


    /**
     * Initialisons la page
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../application/MainScene.fxml"));
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
    public void bouttonEffacerExiste(){
        verifyThat(ID_BOUTTON_SUPPRIMER, NodeMatchers.isNotNull());
    }


    /**
     * on verifie si le champs resultat est dans linterface
     */
    @Test
    public void champResultatExiste(){
        verifyThat(ID_RESULT_TEXT, NodeMatchers.isNotNull());
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
        //on clique sur le champ a et on met une valeur
        clickOn(ID_A_TEXT);
        write("4");

        //on clique sur le champ b et on met une valeur
        clickOn(ID_B_TEXT);
        write("4");

        //on clique sur le champ a et on met une valeur
        clickOn(ID_C_TEXT);
        write("1");

        //puis on clique sur le boutton resoudre
        clickOn(ID_BOUTTON_VALIDER);

        //on recupere la valeur du resultat puis on compare au bon resultat grace a la fonction resolution
        //pour rappel resolution renvoie vrai quand il y a un bon resultat
        if(resolution(4, 4, 1)) {
            if(x1==x2) {
                verifyThat(ID_RESULT_TEXT, TextMatchers.hasText("Le syst�me admet une solution double x0 :"+x1+" S = {"+x2+"}"));
            }else {
                verifyThat(ID_RESULT_TEXT, TextMatchers.hasText("Les solutions sont x1: "+x1 +"x2: "+x2+" S = {"+x1+" , "+x2+"}"));
            }
        }else {
            verifyThat(ID_RESULT_TEXT, TextMatchers.hasText("Le syst�me n'admet pas de solutions dans R"));
        }



    }


    /**
     * Cette fonction verifie si le bouton effacer supprime bien tout dans les champs
     */
    @Test
    public void effacerTexte() {
        //on clique sur le champ a et on met une valeur
        clickOn(ID_A_TEXT);
        write("13");

        //on clique sur le champ b et on met une valeur
        clickOn(ID_B_TEXT);
        write("56");

        //on clique sur le champ a et on met une valeur
        clickOn(ID_C_TEXT);
        write("22");

        //puis on clique sur le boutton resoudre
        clickOn(ID_BOUTTON_VALIDER);

        //on clique qur le boutton effacer
        clickOn(ID_BOUTTON_SUPPRIMER);

        //on verifie si les champs a, b et c sont vides et si le resultat est vide
        verifyThat(ID_RESULT_TEXT,TextMatchers.hasText(""));
        verifyThat(ID_A_TEXT, TextMatchers.hasText(""));
        verifyThat(ID_B_TEXT, TextMatchers.hasText(""));
        verifyThat(ID_C_TEXT,TextMatchers.hasText(""));
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
