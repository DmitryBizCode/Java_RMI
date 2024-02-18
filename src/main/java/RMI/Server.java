package RMI;

import java.rmi.*;
import java.rmi.server.*;
public class Server extends UnicastRemoteObject implements SimpleRMIInterface {
    private String result;
    public Server(String name, String result) throws RemoteException{
        super();
        try{
            Naming.rebind(name, this); }catch(Exception e){
            System.err.println("From rebind: " + e);
        }
        this.result = result;
    }
    public String getResult( ) throws RemoteException{ return result; }
    public static void main(String[] args){
        try{
            Server simp = new Server("rmi://127.0.0.1/myRMI", "Привіт від RMI діма лох");
        }
        catch(Exception e){
            System.err.println("Can't create server: " + e.getMessage ());
        }
    }
}

