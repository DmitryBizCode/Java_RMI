package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SimpleRMIInterface extends Remote {
    String getResult() throws RemoteException;
}
