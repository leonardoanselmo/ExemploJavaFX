package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    protected void btNovoAction(ActionEvent e){
        System.out.println("bt Novo!");

        Main.changeScreen("details");
    }




}
