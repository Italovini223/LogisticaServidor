package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Cris
 */
public interface Interface extends Remote{
    public String olaMundo() throws RemoteException;
    public int soma(int x, int y)throws RemoteException;
    public int calcularIdade(Pessoa p) throws RemoteException;
    public Pessoa alterarPessoa() throws RemoteException;
    public int alterarContador() throws RemoteException;
}
