/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022-2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.ihm;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class JustePrixController {

    private static final Random RANDOM = new Random();
    private static final int MAX_VALUE = 100; // Définissez la valeur maximale ici.
    private int chosenValue = RANDOM.nextInt(MAX_VALUE);
    private int counter = 15; // Le compteur commence à 15.

    @FXML
    private Button button;

    @FXML
    private Label hint;

    @FXML
    private Label question;
    @FXML
    private TextField textInput;

    @FXML
    private Label welcomeText;

    @FXML
    private Label counterLabel;

    private Timeline timeline;

    public JustePrixController() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            counter--;
            counterLabel.setText(String.valueOf(counter));
            if (counter <= 0) {
                timeline.stop();
                hint.setText("Vous avez perdu, une bombe nucléaire a été larguée dans un endroit aléatoire de cette planète.");
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    @FXML
    void initialize() {
        counterLabel.setText(String.valueOf(counter));
        timeline.play();
    }

    @FXML
    void entreeButtonClick(ActionEvent event) {
        try {
            int userValue = Integer.parseInt(textInput.getText());
            if (userValue < chosenValue) {
                hint.setText("C'est plus !");
            } else if (userValue > chosenValue) {
                hint.setText("C'est moins !");
            } else {
                timeline.stop();
                hint.setText("VOUS AVEZ TROUVE LEEEET'S GOOOOOOOOOOOOOOOOOOOOOOOO !");
            }
        } catch (NumberFormatException e) {
            hint.setText("Veuillez entrer un nombre valide.");
        }
    }

    @FXML
    void onButtonClick(ActionEvent event) {
        try {
            int userValue = Integer.parseInt(textInput.getText());
            if (userValue < chosenValue) {
                hint.setText("C'est plus !");
            } else if (userValue > chosenValue) {
                hint.setText("C'est moins !");
            } else {
                timeline.stop();
                hint.setText("VOUS AVEZ TROUVE LEEEET'S GOOOOOOOOOOOOOOOOOOOOOOOO !");
            }
        } catch (NumberFormatException e) {
            hint.setText("Veuillez entrer un nombre valide.");
        }
    }

}