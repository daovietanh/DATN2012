
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VietAnh
 */
public class FactoryServiceImpl implements FactoryService {

    If_Database DatabaseObject = new Cl_Database();

    public FactoryServiceImpl()
    {
        try
        {
            UnicastRemoteObject.exportObject(DatabaseObject);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        
    }
    @Override
    public If_Database CreateDatabase() throws RemoteException {
        return DatabaseObject;
    }

}
