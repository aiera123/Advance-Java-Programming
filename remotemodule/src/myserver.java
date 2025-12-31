import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class myserver extends UnicastRemoteObject implements App {
    protected myserver() throws RemoteException {
        super();
    }
    public static void main(String[] args) throws Exception {

        Registry reg = LocateRegistry.createRegistry(5000);
        reg.rebind("hi_server", new myserver());
        System.out.println("Server is Now Ready..");
    }
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

}




