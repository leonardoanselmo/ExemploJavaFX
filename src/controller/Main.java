package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage;

    private static Scene mainScene;
    private static Scene detailsScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;

        primaryStage.setTitle("Exemplo JavaFX 8");

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("../view/main_screen.fxml"));
        mainScene = new Scene(fxmlMain, 640, 400);

        Parent fxmlDetails = FXMLLoader.load(getClass().getResource("../view/details_screen.fxml"));
        detailsScene = new Scene(fxmlDetails, 640, 400);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void changeScreen(String scr){

        switch (scr){
            case "main":
                stage.setScene(mainScene);
                break;
            case "details":
                stage.setScene(detailsScene);
                break;

        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static interface onChangeScreen{

         

    }
}
