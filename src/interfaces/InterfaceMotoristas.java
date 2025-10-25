package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.MotoristasModel;

public interface  InterfaceMotoristas extends Remote {
  public boolean inserir(MotoristasModel motorista)throws RemoteException;
  public boolean editar(MotoristasModel motorista) throws RemoteException;
  public boolean excluir (MotoristasModel motorista)throws RemoteException;
  public MotoristasModel pesquisar(MotoristasModel motorista) throws RemoteException;
  public ArrayList<MotoristasModel> listar() throws RemoteException;

}
