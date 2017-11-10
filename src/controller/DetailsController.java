package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Veiculo;


public class DetailsController {

    private Veiculo veiculoAtual;

    @FXML
    private TextField tfMarca;

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfHP;
    private Veiculo v;

    @FXML
    protected void initialize(){
        Main.addOnChangeScreenListeners(new Main.onChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (newScreen.equals("details")) {

                    if (userData != null){
                        veiculoAtual = (Veiculo) userData;
                        tfMarca.setText(veiculoAtual.getMarca());
                        tfModelo.setText(veiculoAtual.getModelo());
                        tfHP.setText(String.valueOf(veiculoAtual.getHp()));
                    } else {

                        veiculoAtual = null;

                        tfMarca.setText("");
                        tfModelo.setText("");
                        tfHP.setText("");
                    }

                }
            }
        });
    }

    @FXML
    protected void btCancelarAction(ActionEvent e){
        Main.changeScreen("main");
    }

    @FXML
    void btOkAction(ActionEvent event) {

        try {

            if (tfMarca.getText().isEmpty())
                throw new RuntimeException("Marca deve ser preenchido.");


            if (tfModelo.getText().isEmpty())
                throw new RuntimeException("Modelo deve ser preenchido.");


            if (veiculoAtual != null){
                veiculoAtual.setMarca(tfMarca.getText());
                veiculoAtual.setModelo(tfModelo.getText());
                veiculoAtual.setHp(Integer.parseInt(tfHP.getText()));

                veiculoAtual.save();
            } else {
                Veiculo v = new Veiculo(tfMarca.getText(),
                        tfModelo.getText(),
                        Integer.parseInt(tfHP.getText()));

                v.save();
            }


            Main.changeScreen("main");
        } catch (NumberFormatException ex) {
            mensagensAlert("Erro ao criar veículo.", "O campo HP deve ser um valor numérico");
        } catch (RuntimeException ex){
            mensagensAlert("Erro ao criar veículo.", ex.getMessage());
        }
    }

    private void mensagensAlert(String mensagem, String context){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(mensagem);
        alert.setContentText(context);
        alert.showAndWait();
    }

}
