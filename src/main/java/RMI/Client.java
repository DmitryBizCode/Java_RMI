package RMI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rmi_controller.java_rmi.HelloApplication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.rmi.Naming;
import java.util.Scanner;

public class Client extends Application {
    @FXML
    private TextField Xnum;

    @FXML
    private TextField Ynum;

    @FXML
    private TextField Cnum;

    @FXML
    private Label Result;

    @FXML
    private void calculate() {
        new Thread(() -> {
            try {
                String xInput = Xnum.getText();
                String yInput = Ynum.getText();
                String cInput = Cnum.getText();

                if (xInput.isEmpty() || yInput.isEmpty() || cInput.isEmpty()) {
                    Platform.runLater(() -> Result.setText("Please enter valid numbers"));
                    return;
                }

                try {
                    double value1 = Double.parseDouble(xInput);
                    double value2 = Double.parseDouble(yInput);
                    double value3 = Double.parseDouble(cInput);
                    try{
                        SimpleRMIInterface simp = (SimpleRMIInterface) Naming.lookup("rmi://localhost/myRMI");
                        double result = simp.calculateResult(value1, value2, value3);
                        Platform.runLater(() -> Result.setText("Result: " + result));
                    }
                    catch (Exception e) {
                        System.err.println("Не вдалося знайти сервер: " + e.getMessage());
                    }
                } catch (NumberFormatException e) {
                    Platform.runLater(() -> Result.setText("Please enter valid numbers"));
                }
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
                Platform.runLater(() -> Result.setText("Error occurred"));
            }
        }).start();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClientFX.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Client application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}