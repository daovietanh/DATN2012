
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VietAnh
 */
public interface FactoryService extends Remote{
    public If_Database CreateDatabase() throws RemoteException ;


}
