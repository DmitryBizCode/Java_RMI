package RMI;

import java.rmi.*;

public class SimpleRMIClient{
    public static void main(String[] args){
        try{
            SimpleRMIInterface simp = (SimpleRMIInterface)Naming.lookup ("rmi://localhost/myRMI");
            System.out.println("Відповідь від сервера: " + simp.getResult());
        }
        catch(Exception e){
            System.err.println("Can't find the server: " + e.getMessage() );
        }
    }
}

