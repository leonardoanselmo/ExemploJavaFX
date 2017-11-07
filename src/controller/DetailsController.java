package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;



public class DetailsController {

    @FXML
    protected void btCancelarAction(ActionEvent e){
        System.out.println("bt cancelar");
        Main.changeScreen("main");
    }

}
