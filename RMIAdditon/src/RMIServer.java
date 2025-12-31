import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            AddInterface obj = new AddImplementation();
            Naming.rebind("rmi://localhost/AddService", obj);
            System.out.println("RMI Server is ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

