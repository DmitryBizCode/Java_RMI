package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SimpleRMIInterface extends Remote {
    String getResult() throws RemoteException;

    double calculateResult(double num1, double num2, double num3) throws RemoteException;
}
