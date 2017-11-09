package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Veiculo;
import model.sqlite.VeiculoSQLite;

import java.util.ArrayList;

public class Main extends Application {

    private static Stage stage;

    private static Scene mainScene;
    private static Scene detailsScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Veiculo veiculo = new Veiculo("chevrolet", "corsa", 80);

        VeiculoSQLite database = new VeiculoSQLite();

        database.create(veiculo);

        System.out.println(database.all());

        System.exit(0);

        stage = primaryStage;

        primaryStage.setTitle("Exemplo JavaFX 8");

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("../view/main_screen.fxml"));
        mainScene = new Scene(fxmlMain, 640, 400);

        Parent fxmlDetails = FXMLLoader.load(getClass().getResource("../view/details_screen.fxml"));
        detailsScene = new Scene(fxmlDetails, 640, 400);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void changeScreen(String scr, Object userData){

        switch (scr){
            case "main":
                stage.setScene(mainScene);
                notifyAllListeners("main", userData);
                break;
            case "details":
                stage.setScene(detailsScene);
                notifyAllListeners("details", userData);
                break;

        }

    }

    public static void changeScreen(String scr){
        changeScreen(scr, null);
    }

    public static void main(String[] args) {
        launch(args);
    }

    // ---------------

    public static ArrayList<onChangeScreen> listeners = new ArrayList<>();

    public static interface onChangeScreen{
         void onScreenChanged(String newScreen, Object userData);
    }

    public static void addOnChangeScreenListeners(onChangeScreen newListener){
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Object userData){
        for(onChangeScreen l : listeners){
            l.onScreenChanged(newScreen, userData);
        }
    }


}
