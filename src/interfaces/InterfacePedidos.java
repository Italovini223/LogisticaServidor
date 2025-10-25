package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.PedidosModel;


public interface InterfacePedidos extends Remote {
  public boolean inserir(PedidosModel pedido)throws RemoteException;
  public boolean editar(PedidosModel pedido) throws RemoteException;
  public boolean excluir (PedidosModel pedido)throws RemoteException;
  public PedidosModel pesquisar(PedidosModel pedido) throws RemoteException;
  public ArrayList<PedidosModel> listar() throws RemoteException;
  public ArrayList<PedidosModel> listarPorEntrega(int idPedido) throws RemoteException;
  public ArrayList<PedidosModel> listarPorCliente(int idCliente) throws RemoteException;
}
