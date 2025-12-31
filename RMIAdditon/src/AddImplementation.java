import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddImplementation extends UnicastRemoteObject
        implements AddInterface {

    protected AddImplementation() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}

