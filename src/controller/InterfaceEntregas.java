package controller;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceEntregas extends Remote {
  public boolean inserir(model.EntregasModel entrega)throws RemoteException;
  public boolean editar(model.EntregasModel entrega) throws RemoteException;
  public boolean excluir (model.EntregasModel entrega)throws RemoteException;
  public model.EntregasModel pesquisar(model.EntregasModel entrega) throws RemoteException;
  public ArrayList<model.EntregasModel> listar() throws RemoteException;

} 