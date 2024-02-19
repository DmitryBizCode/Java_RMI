package RMI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerController extends Application {

    @FXML
    private Label TimerClient;

    @FXML
    private Label Result;
    private static ServerController instance;

    public static ServerController getInstance() {
        return instance;
    }

    public void setResult(String resultInString) {
        Platform.runLater(() -> {
            if (Result != null) {
                Result.setText("Last submitted result: "+resultInString);
            } else {
                System.err.println("Result label is null");
            }
        });
    }
    public void setTimer(String timerInString) {
        Platform.runLater(() -> {
            if (TimerClient != null) {
                TimerClient.setText("Server worked with "+timerInString+" clients");
            } else {
                System.err.println("Result label is null");
            }
        });
    }

    @Override
    public void start(Stage stage) throws IOException {
        instance = this;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ServerFX.fxml"));
        Parent root = fxmlLoader.load();

        // Assuming your Result label is defined in ServerFX.fxml, you can find it using lookup
        Result = (Label) root.lookup("#Result");
        TimerClient = (Label) root.lookup("#TimerClient");
        Scene scene = new Scene(root, 500, 400);

        stage.setTitle("RMI server");
        stage.setScene(scene);
        stage.show();
    }
}
