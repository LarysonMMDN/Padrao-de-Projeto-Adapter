package laryson.martins;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                MainApplication.class.getResource("/view/Calculadora.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 300, 400);

        stage.setTitle("Calculadora Matemática");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}