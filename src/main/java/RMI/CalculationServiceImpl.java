/*package RMI;
import java.rmi.*;


import java.rmi.server.UnicastRemoteObject;

public class CalculationServiceImpl extends UnicastRemoteObject implements CalculationService {
    public CalculationServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public double calculate(double x, double y, double c) throws RemoteException {
        double result = 0;
        for (int i = 1; i <= 30; i++) {
            result += ((Math.pow(-i, i + 1)) * ((Math.sin(x) * Math.cos(y) + Math.tan(c)) / factorial(i + 3)));
        }
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
}
*/