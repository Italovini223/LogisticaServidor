package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.EntregasModel;

public interface InterfaceEntregas extends Remote {
  public boolean inserir(EntregasModel entrega)throws RemoteException;
  public boolean editar(EntregasModel entrega) throws RemoteException;
  public boolean excluir (EntregasModel entrega)throws RemoteException;
  public EntregasModel pesquisar(EntregasModel entrega) throws RemoteException;
  public ArrayList<EntregasModel> listar() throws RemoteException;
  public ArrayList<EntregasModel> listarPorMotorista(int idMotorista) throws RemoteException;
  public ArrayList<EntregasModel> listarPorCaminhao(int idCaminhao) throws RemoteException;

} 