package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Veiculo;

public class MainController {

    @FXML
    private ListView<Veiculo> lvVeiculos;

    @FXML
    protected void initialize(){
        Main.addOnChangeScreenListeners(new Main.onChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (newScreen.equals("main")) {
                    updateList();
                }
            }
        });
        updateList();
    }

    @FXML
    protected void btNovoAction(ActionEvent e){
        Main.changeScreen("details", "dados para a tela detalhes");
    }

    private void updateList(){

        lvVeiculos.getItems().clear();
        for(Veiculo v :Veiculo.all()){
            lvVeiculos.getItems().add(v);
        };

    }




}
