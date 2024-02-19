package RMI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.atomic.AtomicInteger;

public class Server extends UnicastRemoteObject implements SimpleRMIInterface {
    public Server() throws RemoteException {
        super();
    }

    @Override
    public String getResult() throws RemoteException {
        return "Привіт від RMI";
    }
    Integer countClient = 0;
    @Override
    public double calculateResult(double num1, double num2, double num3) throws RemoteException {
        double result = 0;
        for (int i = 1; i <= 30; i++) {
            result += ((Math.pow(-i, i + 1)) * ((Math.sin(num1) * Math.cos(num2) + Math.tan(num3)) / factorial(i + 3)));
        }
        final double res = result;
        Platform.runLater(() -> {
            ServerController myJavaFXAppInstance = ServerController.getInstance();
            if (myJavaFXAppInstance != null) {
                myJavaFXAppInstance.setTimer(Integer.toString(++countClient));
                myJavaFXAppInstance.setResult(Double.toString(res));
            }
        });

        return result;
    }

    private int factorial(int iteration) {
        try {
            if (iteration <= 0)
                return 0;
            int res_factorial = 1;
            for (int i = 1; i <= iteration; i++) {
                res_factorial *= i;
            }
            return res_factorial;
        } catch (Exception e) {
            System.err.println("An error occurred while calculating factorial: " + e.getMessage());
            return -1;
        }
    }
    public static void main(String[] args) {
        try {
            Server simp = new Server();
            Naming.rebind("rmi://localhost/myRMI", simp);
            System.out.println("Сервер готовий");

            // Launch the JavaFX application
            Application.launch(ServerController.class, args);
        } catch (Exception e) {
            System.err.println("Виникла помилка при створенні сервера: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
