package controller;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceProdutosPedido extends Remote {
  public boolean inserir(model.ProdutosPedidoModel produtoPedido)throws RemoteException;
  public boolean editar(model.ProdutosPedidoModel produtoPedido) throws RemoteException;
  public boolean excluir (model.ProdutosPedidoModel produtoPedido)throws RemoteException;
  public model.ProdutosPedidoModel pesquisar(model.ProdutosPedidoModel produtoPedido) throws RemoteException;
  public ArrayList<model.ProdutosPedidoModel> listarPorPedido(int idPedido) throws RemoteException;
}
